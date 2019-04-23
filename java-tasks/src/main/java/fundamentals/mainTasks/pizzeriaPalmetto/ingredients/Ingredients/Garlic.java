package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class Garlic extends Ingredient {
    private String typeGarlic;

    public Garlic() {
        super("Garlic", new BigDecimal(0.3));
    }

    public String getTypeGarlic() {
        return typeGarlic;
    }

    public void setTypeGarlic(String typeGarlic) {
        this.typeGarlic = typeGarlic;
    }
}
