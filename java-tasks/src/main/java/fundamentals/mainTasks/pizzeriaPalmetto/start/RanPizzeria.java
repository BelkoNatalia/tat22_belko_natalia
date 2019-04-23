package fundamentals.mainTasks.pizzeriaPalmetto.start;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients.*;
import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Pizza;
import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.TypePizza;
import fundamentals.mainTasks.pizzeriaPalmetto.start.ownExceptions.*;

public class RanPizzeria {
    public static void main(String[] args) {
        try {
            Order order1 = new Order(7717);
            Order order2 = new Order(4372);

            Pizza firstPizza = order1.cratePizza("Margarita", TypePizza.CALZONE);
            Pizza secondPizza = order1.cratePizza("PepperonyOro", TypePizza.BASIC);
            Pizza thirdPizza = order1.cratePizza("BasePZZ", TypePizza.BASIC);

            try {
                order1.addIngredient(firstPizza, new TomatoPaste())
                        .addIngredient(firstPizza, new Pepper())
                        .addIngredient(firstPizza, new Garlic())
                        .addIngredient(firstPizza, new Bacon());
                order1.addPizza(firstPizza, 2);

                order1.addIngredient(secondPizza, new TomatoPaste())
                        .addIngredient(secondPizza, new Cheese())
                        .addIngredient(secondPizza, new Salami())
                        .addIngredient(secondPizza, new Olives());
                order1.addPizza(secondPizza, 3);

                System.out.println(order1);

                order2.addIngredient(thirdPizza, new TomatoPaste())
                        .addIngredient(thirdPizza, new Olives())
                        .addIngredient(thirdPizza, new Bacon())
                        .addIngredient(thirdPizza, new Salami());
                order2.addPizza(thirdPizza, 12);
                System.out.println(order2);
            } catch (ExcessIngredientException e) {
                System.out.println(e.getMessage());
            } catch (RepeatIngredientException e) {
                System.out.println(e.getMessage());
            } catch (ExcessPizzaAmountException e) {
                System.out.println(e.getMessage());
            } catch (PizzaExistException e) {
                System.out.println(e.getMessage());
            }
        } catch (OrderNumberOutOfBoundsException e) {
            e.getMessage();
        }
    }
}
