package fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredients;

import fundamentals.mainTasks.pizzeriaPalmetto.ingredients.Ingredient;

import java.math.BigDecimal;

public class TomatoPaste extends Ingredient {
    private String typeTomato;

    public TomatoPaste() {
        super("TomatoPaste", new BigDecimal(1));
    }

    public String getTypeTomato() {
        return typeTomato;
    }

    public void setTypeTomato(String typeTomato) {
        this.typeTomato = typeTomato;
    }

}
