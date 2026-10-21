package kz.aida.pricing;

public class HourlyPricing implements PricingStrategy {

    @Override
    public double calculatePrice(int hours, double distance) {
        return hours * 10000;
    }
}
