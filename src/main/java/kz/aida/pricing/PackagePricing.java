package kz.aida.pricing;

public class PackagePricing implements PricingStrategy {

    @Override
    public double calculatePrice(int hours, double distance) {
        if (hours <= 2) {
            return 18000;
        }
        return 18000 + (hours - 2) * 8000;
    }
}
