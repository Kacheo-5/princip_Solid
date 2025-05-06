package services;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorFactory {
    private final List<TaxCalculator> calculators = new ArrayList<>();

    public TaxCalculatorFactory() {
        calculators.add(new ElectronicsTaxCalculator());
        calculators.add(new DefaultTaxCalculator());
    }

    public TaxCalculator getCalculator(String category) {
        return calculators.stream()
            .filter(calculator -> calculator.supports(category))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No TaxCalculator found for category: " + category));
    }
}
