package fundamentals.mainTasks.pizzeriaPalmetto.ingredients;

import java.math.BigDecimal;

public enum TypePizza {
    BASIC("Pizza Base", new BigDecimal(1)), CALZONE("Pizza Base (Calzone)", new BigDecimal(1.5));

    private String nameBasePizza;
    private BigDecimal costBasePizza;

    private TypePizza(String typePizza, BigDecimal costBasePizza) {
        this.nameBasePizza = typePizza;
        this.costBasePizza = costBasePizza.setScale(2, BigDecimal.ROUND_CEILING);
    }

    public String getNameBasePizza() {
        return nameBasePizza;
    }

    public BigDecimal getCostBasePizza() {
        return costBasePizza;
    }
}
