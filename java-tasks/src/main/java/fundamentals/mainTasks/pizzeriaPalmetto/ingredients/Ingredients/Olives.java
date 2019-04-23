package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class Olives extends Ingredient {
    private String typeOlive;

    public Olives() {
        super("Olives", new BigDecimal(0.5));
    }

    public String getTypeOlive() {
        return typeOlive;
    }

    public void setTypeOlive(String typeOlive) {
        this.typeOlive = typeOlive;
    }
}
