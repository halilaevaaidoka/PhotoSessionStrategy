package kz.aida.pricing;

public class PricingContext {

    private PricingStrategy strategy;

    public PricingContext(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(int hours, double distance) {
        return strategy.calculatePrice(hours, distance);
    }
}
