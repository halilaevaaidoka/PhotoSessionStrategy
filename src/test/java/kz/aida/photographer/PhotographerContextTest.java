package kz.aida.photographer;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhotographerContextTest {

    @Test
    void testRuntimeSwitching() {

        List<Photographer> photographers = List.of(
                new Photographer("Anna", 5, 3, "PORTRAIT"),
                new Photographer("Dana", 8, 5, "WEDDING"),
                new Photographer("Aruzhan", 3, 1, "FAMILY")
        );

        PhotographerContext context =
                new PhotographerContext(
                        new ExperienceStrategy());

        assertEquals("Dana",
                context.selectPhotographer(
                        photographers, "WEDDING").getName());

        context.setStrategy(new AvailabilityStrategy());

        assertEquals("Aruzhan",
                context.selectPhotographer(
                        photographers, "WEDDING").getName());

        context.setStrategy(new SpecializationStrategy());

        assertEquals("Dana",
                context.selectPhotographer(
                        photographers, "WEDDING").getName());
    }
}
