package fundamentals.mainTasks.pizzeriaPalmetto.ingredients;

import java.math.BigDecimal;

public abstract class Ingredient {
    private String ingredientName;
    private BigDecimal costIngredient;

    public Ingredient(String ingredientName, BigDecimal costIngredient) {
        this.ingredientName = ingredientName;
        this.costIngredient = costIngredient.setScale(2, BigDecimal.ROUND_CEILING);

    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public BigDecimal getCostIngredient() {
        return costIngredient;
    }

    public void setCostIngredient(BigDecimal costIngredient) {
        this.costIngredient = costIngredient;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientName='" + ingredientName + '\'' +
                ", costIngredient=" + costIngredient +
                '}';
    }
}
