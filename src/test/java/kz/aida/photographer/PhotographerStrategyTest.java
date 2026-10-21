
package kz.aida.photographer;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhotographerStrategyTest {

    private final List<Photographer> photographers = List.of(
            new Photographer("Anna", 5, 3, "PORTRAIT"),
            new Photographer("Dana", 8, 5, "WEDDING"),
            new Photographer("Aruzhan", 3, 1, "FAMILY")
    );

    @Test
    void testExperienceStrategy() {
        PhotographerStrategy strategy = new ExperienceStrategy();

        Photographer result =
                strategy.selectPhotographer(photographers, "WEDDING");

        assertEquals("Dana", result.getName());
    }

    @Test
    void testAvailabilityStrategy() {
        PhotographerStrategy strategy = new AvailabilityStrategy();

        Photographer result =
                strategy.selectPhotographer(photographers, "WEDDING");

        assertEquals("Aruzhan", result.getName());
    }

    @Test
    void testSpecializationStrategy() {
        PhotographerStrategy strategy = new SpecializationStrategy();

        Photographer result =
                strategy.selectPhotographer(photographers, "WEDDING");

        assertEquals("Dana", result.getName());
    }

    @Test
    void testAutomaticSelector() {
        PhotographerSelector selector = new PhotographerSelector();

        PhotographerStrategy strategy =
                selector.selectStrategy("WEDDING", false);

        assertInstanceOf(SpecializationStrategy.class, strategy);
    }
}
