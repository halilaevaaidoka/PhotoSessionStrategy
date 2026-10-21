package kz.aida.pricing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PricingSelectorTest {

    private final PricingSelector selector =
            new PricingSelector();

    @Test
    void testHourlySelection() {
        PricingStrategy strategy =
                selector.selectStrategy(2, 10);

        assertInstanceOf(HourlyPricing.class, strategy);
    }

    @Test
    void testPackageSelection() {
        PricingStrategy strategy =
                selector.selectStrategy(3, 10);

        assertInstanceOf(PackagePricing.class, strategy);
    }

    @Test
    void testDistanceSelection() {
        PricingStrategy strategy =
                selector.selectStrategy(2, 25);

        assertInstanceOf(DistancePricing.class, strategy);
    }

    @Test
    void testDistancePriority() {
        PricingStrategy strategy =
                selector.selectStrategy(3, 25);

        assertInstanceOf(DistancePricing.class, strategy);
    }
}
