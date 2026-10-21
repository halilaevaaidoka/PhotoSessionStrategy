package kz.aida.pricing;

public class PricingSelector {

    public PricingStrategy selectStrategy(
            int hours, double distance) {

        if (distance > 20) {
            return new DistancePricing(new FixedDistanceProvider());
        }

        if (hours >= 3) {
            return new PackagePricing();
        }

        return new HourlyPricing();
    }
}
