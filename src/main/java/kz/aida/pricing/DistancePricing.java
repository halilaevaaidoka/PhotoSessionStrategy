
package kz.aida.pricing;

public class DistancePricing implements PricingStrategy {

    private final DistanceProvider distanceProvider;

    public DistancePricing(DistanceProvider distanceProvider) {
        this.distanceProvider = distanceProvider;
    }

    @Override
    public double calculatePrice(int hours, double distance) {
        double actualDistance = distanceProvider.getDistanceKm();
        return hours * 10000 + actualDistance * 500;
    }
}
