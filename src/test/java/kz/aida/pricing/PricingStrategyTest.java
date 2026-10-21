package kz.aida.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class PricingStrategyTest {

    @Test
    void testHourlyPricing() {
        PricingStrategy strategy = new HourlyPricing();

        assertEquals(20000,
                strategy.calculatePrice(2, 10));
    }

    @Test
    void testPackagePricing() {
        PricingStrategy strategy = new PackagePricing();

        assertEquals(18000,
                strategy.calculatePrice(2, 10));
    }

    @Test
    void testDistancePricing() {
        DistanceProvider fakeProvider = () -> 10.0;

        PricingStrategy strategy =
                new DistancePricing(fakeProvider);

        assertEquals(25000,
                strategy.calculatePrice(2, 10));
    }


    static Stream<Arguments> pricingStrategies() {
        return Stream.of(
                Arguments.of(new HourlyPricing(), 20000.0),
                Arguments.of(new PackagePricing(), 18000.0),
                Arguments.of(
                        new DistancePricing(() -> 10.0),
                        25000.0)
        );
    }

    @ParameterizedTest
    @MethodSource("pricingStrategies")
    void testAllPricingStrategies(
            PricingStrategy strategy, double expected) {

        assertEquals(expected,
                strategy.calculatePrice(2, 10));
    }

}
