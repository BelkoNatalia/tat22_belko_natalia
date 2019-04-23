package fundamentals.mainTasks.pizzeriaPalmetto.start;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;
import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Pizza;
import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.TypePizza;
import fundamentals.mainTasks.pizzeriaPalmetto.start.ownExceptions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int lastOderNumber = 9999;
    private static final int MAX_PIZZA_AMOUNT_PER_PIZZA_NAME = 10;
    private static final int MAX_NUMBER_INGREDIENT_IN_PIZZA = 7;
    private int oderNumber;
    private int clientNumber;
    private List<Pizza> pizzaList = new ArrayList<>();


    public Order(int clientNumber) throws OrderNumberOutOfBoundsException {
        lastOderNumber = lastOderNumber + 1;
        oderNumber = lastOderNumber;
        if (oderNumber > 99999) {
            throw new OrderNumberOutOfBoundsException("Order number value exceeded");
        }
        this.clientNumber = clientNumber;
    }

    public Pizza cratePizza(String namePizza, TypePizza typePizza) {
        String currentNamePizza = namePizza;
        if (!currentNamePizza.matches("[A-Za-z]{4,20}")) {
            currentNamePizza = "Клиент " + oderNumber;
        }
        return new Pizza(currentNamePizza, typePizza);
    }

    public Order addIngredient(Pizza pizza, Ingredient ingredient) throws ExcessIngredientException, RepeatIngredientException {
        if (isIngredientExist(pizza, ingredient)) {
            throw new RepeatIngredientException("Ingredient exist. Please check the order!");
        }
        if (!isSuitableNumberIngredient(pizza)) {
            throw new ExcessIngredientException("Pizza is full");
        }
        pizza.getIngredientList().add(ingredient);
        return this;
    }

    private boolean isSuitableNumberIngredient(Pizza pizza) {
        List<Ingredient> currentListIngredients = pizza.getIngredientList();
        int currentNumberIngredients = currentListIngredients.size();
        return (currentNumberIngredients != MAX_NUMBER_INGREDIENT_IN_PIZZA);
    }

    private boolean isIngredientExist(Pizza pizza, Ingredient ingredient) {
        List<Ingredient> currentListIngredients = pizza.getIngredientList();
        boolean isIngredientExist = false;
        for (Ingredient currentIngredient : currentListIngredients) {
            if (currentIngredient.getIngredientName().equals(ingredient.getIngredientName())) {
                isIngredientExist = true;
            }
        }
        return isIngredientExist;
    }

    public void addPizza(Pizza pizza, int amountPizza) throws ExcessPizzaAmountException, PizzaExistException {
        if (isPizzaExist(pizza)) {
            throw new PizzaExistException("Pizza exists in order");
        }
        if (!isSuitablePizzaAmount(amountPizza)) {
            throw new ExcessPizzaAmountException("Pizza '" + pizza.getPizzaName() + "' count exceeded.");
        }
        pizza.setAmountPizza(amountPizza);
        pizzaList.add(pizza);
    }

    private boolean isPizzaExist(Pizza pizza) {
        boolean isPizzaExist = false;
        for (Pizza currentPizza : pizzaList) {
            if (currentPizza.getPizzaName().equals(pizza.getPizzaName())) {
                isPizzaExist = true;
            }
        }
        return isPizzaExist;
    }

    private boolean isSuitablePizzaAmount(int amountPizza) {
        return amountPizza <= MAX_PIZZA_AMOUNT_PER_PIZZA_NAME;
    }

    public void changeAmountPizza(Pizza pizza, int newAmountPizza) throws ExcessPizzaAmountException {
        for (Pizza currentPizza : pizzaList) {
            if (currentPizza.getPizzaName().equals(pizza.getPizzaName())) {
                if (!isSuitablePizzaAmount(newAmountPizza)) {
                    throw new ExcessPizzaAmountException("Pizza '" + pizza.getPizzaName() + "' count exceeded");
                }
                currentPizza.setAmountPizza(newAmountPizza);
            }
        }
    }

    public void printAttributesPizza(String pizzaName) {
        for (Pizza currentPizza : pizzaList) {
            if (currentPizza.getPizzaName().equals(pizzaName)) {
                System.out.println("[" + oderNumber + ": " + clientNumber + ": "
                        + currentPizza.getPizzaName() + ": " + currentPizza.getAmountPizza() + "]");
            }
        }
    }

    public BigDecimal getPizzaCost(Pizza pizza) {
        BigDecimal pizzaCost = pizza.getTypePizza().getCostBasePizza();
        for (Pizza currentPizza : pizzaList) {
            if (currentPizza.getPizzaName().equals(pizza.getPizzaName())) {
                List<Ingredient> currentIngredientList = currentPizza.getIngredientList();
                for (Ingredient currentIngredient : currentIngredientList) {
                    pizzaCost = pizzaCost.add(currentIngredient.getCostIngredient());
                }
            }
        }
        return pizzaCost;
    }

    public BigDecimal getAllOrderCost() {
        BigDecimal orderCost = BigDecimal.ZERO;
        for (Pizza currentPizza : pizzaList) {
            BigDecimal amountPizzaBigDecimal = new BigDecimal(currentPizza.getAmountPizza());
            orderCost = orderCost.add(getPizzaCost(currentPizza).multiply(amountPizzaBigDecimal));
        }
        return orderCost;
    }

    private String printMainPartOrder() {
        StringBuilder mainPartOrderText = new StringBuilder();
        mainPartOrderText.append("*********************************")
                .append("\nЗаказ: ")
                .append(oderNumber)
                .append("\nКлиент: ")
                .append(clientNumber);
        return mainPartOrderText.toString();
    }

    private String printPizzaName(Pizza pizza) {
        StringBuilder pizzaNameText = new StringBuilder();
        pizzaNameText.append("\nНазвание: ")
                .append(pizza.getPizzaName())
                .append("\n---------------------------------");
        return pizzaNameText.toString();
    }

    private String printBasePizza(Pizza pizza) {
        String currentPizzaBaseName = pizza.getTypePizza().getNameBasePizza();
        BigDecimal currentPizzaBaseCost = pizza.getTypePizza().getCostBasePizza();
        String basePizzaText = String.format("\n%-20s %10s €", currentPizzaBaseName, currentPizzaBaseCost);
        return basePizzaText;
    }

    private String printIngredient(Ingredient currentIngredient) {
        String ingredientName = currentIngredient.getIngredientName();
        BigDecimal currentIngredientCost = currentIngredient.getCostIngredient();
        String ingredientString = String.format("%-20s %10s €", ingredientName, currentIngredientCost);
        String ingredientText = "\n" + ingredientString;
        return ingredientText;
    }

    private String printAllPizzaCost(Pizza pizza){
        BigDecimal allPizzaCost = getPizzaCost(pizza);
        String allPizzaCostString = String.format("\nВсего: %24s €", allPizzaCost);
        String allPizzaCostText = allPizzaCostString;
        return allPizzaCostText;
    }

    private String printAmountPizza(Pizza pizza){
        String amountPizzaString = String.format("\nКол-во: %25s", pizza.getAmountPizza());
        String amountPizzaText = amountPizzaString + "\n---------------------------------";
        return amountPizzaText;
    }

    private String printAllOrderCost(){
        String allOrderCostString = String.format("\nОбщая сумма: %18s €", getAllOrderCost());
        String allOrderCostText = allOrderCostString + "\n*********************************";
        return allOrderCostText;
    }

    @Override
    public String toString() {
        StringBuilder orderText = new StringBuilder();
        orderText.append(printMainPartOrder());
        for (int i = 0; i < pizzaList.size(); i++) {
            Pizza currentPizza = pizzaList.get(i);
            orderText = orderText.append(printPizzaName(currentPizza))
                    .append(printBasePizza(currentPizza));
            List<Ingredient> currentListIngredient = currentPizza.getIngredientList();
            for (int j = 0; j < currentListIngredient.size(); j++) {
                Ingredient currentIngredient = currentListIngredient.get(j);
                orderText = orderText.append(printIngredient(currentIngredient));
            }
            orderText = orderText.append("\n---------------------------------")
                    .append(printAllPizzaCost(currentPizza))
                    .append(printAmountPizza(currentPizza));
        }
        orderText = orderText.append(printAllOrderCost());
        return orderText.toString();
    }

}
