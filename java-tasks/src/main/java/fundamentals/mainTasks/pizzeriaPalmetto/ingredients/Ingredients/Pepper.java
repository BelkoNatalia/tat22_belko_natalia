package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class Pepper extends Ingredient {
    private String typePepperoni;

    public Pepper() {
        super("Pepper", new BigDecimal(0.6));
    }

    public String getTypePepperoni() {
        return typePepperoni;
    }

    public void setTypePepperoni(String typePepperoni) {
        this.typePepperoni = typePepperoni;
    }

}
