package kz.aida.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PricingContextTest {

    @Test
    void testRuntimeSwitching() {

        PricingContext context =
                new PricingContext(new HourlyPricing());

        assertEquals(20000,
                context.calculatePrice(2, 10));

        context.setStrategy(new PackagePricing());

        assertEquals(18000,
                context.calculatePrice(2, 10));

        context.setStrategy(
                new DistancePricing(() -> 10.0));

        assertEquals(25000,
                context.calculatePrice(2, 10));
    }
}
