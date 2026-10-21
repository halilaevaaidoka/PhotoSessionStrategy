package kz.aida.photographer;

import java.util.List;
import java.util.Comparator;

public class ExperienceStrategy implements PhotographerStrategy {

    @Override
    public Photographer selectPhotographer(
            List<Photographer> photographers, String sessionType) {

        return photographers.stream()
                .max(Comparator.comparingInt(
                        Photographer::getExperience))
                .orElseThrow(() ->
                        new IllegalArgumentException("No photographers"));
    }
}
