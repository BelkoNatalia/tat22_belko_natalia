package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class Cheese extends Ingredient {
    private String typeCheese;

    public Cheese() {
        super("Cheese", new BigDecimal(1));
    }

    public String getTypeCheese() {
        return typeCheese;
    }

    public void setTypeCheese(String typeCheese) {
        this.typeCheese = typeCheese;
    }
}
