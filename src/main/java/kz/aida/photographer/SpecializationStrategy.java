package kz.aida.photographer;

import java.util.List;

public class SpecializationStrategy implements PhotographerStrategy {

    @Override
    public Photographer selectPhotographer(
            List<Photographer> photographers, String sessionType) {

        return photographers.stream()
                .filter(p -> p.getSpecialization()
                        .equalsIgnoreCase(sessionType))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No matching photographer"));
    }
}
