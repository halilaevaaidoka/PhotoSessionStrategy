package kz.aida.photographer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhotographerSelectorTest {

    private final PhotographerSelector selector =
            new PhotographerSelector();

    @Test
    void testUrgentSelection() {
        PhotographerStrategy strategy =
                selector.selectStrategy("WEDDING", true);

        assertInstanceOf(AvailabilityStrategy.class, strategy);
    }

    @Test
    void testWeddingSelection() {
        PhotographerStrategy strategy =
                selector.selectStrategy("WEDDING", false);

        assertInstanceOf(SpecializationStrategy.class, strategy);
    }

    @Test
    void testDefaultSelection() {
        PhotographerStrategy strategy =
                selector.selectStrategy("PORTRAIT", false);

        assertInstanceOf(ExperienceStrategy.class, strategy);
    }

    @Test
    void testUrgentPriority() {
        PhotographerStrategy strategy =
                selector.selectStrategy("PORTRAIT", true);

        assertInstanceOf(AvailabilityStrategy.class, strategy);
    }
}
