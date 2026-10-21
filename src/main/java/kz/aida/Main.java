
package kz.aida;

import kz.aida.pricing.*;
import kz.aida.photographer.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(" PHOTO SESSION STRATEGY ");

        // FAMILY 1: PRICING
        System.out.println("\n PRICING ");

        PricingContext pricing = new PricingContext(
                new HourlyPricing());

        System.out.println("Hourly: " +
                pricing.calculatePrice(2, 10));

        pricing.setStrategy(new PackagePricing());

        System.out.println("Package: " +
                pricing.calculatePrice(2, 10));

        pricing.setStrategy(new DistancePricing(new FixedDistanceProvider()));

        System.out.println("Distance: " +
                pricing.calculatePrice(2, 10));

        PricingSelector pricingSelector = new PricingSelector();

        pricing.setStrategy(
                pricingSelector.selectStrategy(3, 10));

        System.out.println("Automatic pricing: " +
                pricing.calculatePrice(3, 10));

        // FAMILY 2: PHOTOGRAPHER
        System.out.println("\n PHOTOGRAPHER ");

        List<Photographer> photographers = List.of(
                new Photographer("Anna", 5, 3, "PORTRAIT"),
                new Photographer("Dana", 8, 5, "WEDDING"),
                new Photographer("Aruzhan", 3, 1, "FAMILY")
        );

        PhotographerContext context = new PhotographerContext(
                new ExperienceStrategy());

        System.out.println("Experience: " +
                context.selectPhotographer(
                        photographers, "WEDDING").getName());

        context.setStrategy(new AvailabilityStrategy());

        System.out.println("Availability: " +
                context.selectPhotographer(
                        photographers, "WEDDING").getName());

        context.setStrategy(new SpecializationStrategy());

        System.out.println("Specialization: " +
                context.selectPhotographer(
                        photographers, "WEDDING").getName());

        PhotographerSelector selector =
                new PhotographerSelector();

        context.setStrategy(
                selector.selectStrategy("WEDDING", false));

        System.out.println("Automatic photographer: " +
                context.selectPhotographer(
                        photographers, "WEDDING").getName());
    }
}
