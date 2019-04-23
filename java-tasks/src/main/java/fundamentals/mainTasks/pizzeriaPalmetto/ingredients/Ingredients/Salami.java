package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class Salami extends Ingredient {
    private String typeSalami;

    public Salami() {
        super("Salami", new BigDecimal(1.5));
    }

    public String getTypeSalami() {
        return typeSalami;
    }

    public void setTypeSalami(String typeSalami) {
        this.typeSalami = typeSalami;
    }
}
