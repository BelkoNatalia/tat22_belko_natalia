package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class Corn extends Ingredient {
    private String typeCorn;

    public Corn() {
        super("Corn", new BigDecimal(0.7));
    }

    public String getTypeCorn() {
        return typeCorn;
    }

    public void setTypeCorn(String typeCorn) {
        this.typeCorn = typeCorn;
    }
}
