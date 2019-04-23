package fundamentals.mainTasks.pizzeriaPalmetto.ingredients;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String pizzaName;
    private TypePizza typePizza;
    private int amountPizza;
    private List<Ingredient> ingredientList = new ArrayList<>();

    public Pizza(String pizzaName, TypePizza typePizza) {
        this.pizzaName = pizzaName;
        this.typePizza = typePizza;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public TypePizza getTypePizza() {
        return typePizza;
    }

    public void setTypePizza(TypePizza typePizza) {
        this.typePizza = typePizza;
    }

    public int getAmountPizza() {
        return amountPizza;
    }

    public void setAmountPizza(int amountPizza) {
        this.amountPizza = amountPizza;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", typePizza=" + typePizza +
                ", ingredientList=" + ingredientList +
                '}';
    }
}
