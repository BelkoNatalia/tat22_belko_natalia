package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class Bacon extends Ingredient {
    private String typeBacon;

    public Bacon() {
        super("Bacon", new BigDecimal(1.2));
    }

    public String getTypeBacon() {
        return typeBacon;
    }

    public void setTypeBacon(String typeBacon) {
        this.typeBacon = typeBacon;
    }

}
