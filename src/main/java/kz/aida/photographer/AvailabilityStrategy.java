package kz.aida.photographer;

import java.util.List;
import java.util.Comparator;

public class AvailabilityStrategy implements PhotographerStrategy {

    @Override
    public Photographer selectPhotographer(
            List<Photographer> photographers, String sessionType) {

        return photographers.stream()
                .min(Comparator.comparingInt(
                        Photographer::getAvailableInHours))
                .orElseThrow(() ->
                        new IllegalArgumentException("No photographers"));
    }
}
