package kz.aida.photographer;

public class PhotographerSelector {

    public PhotographerStrategy selectStrategy(
            String sessionType, boolean urgent) {

        if (urgent) {
            return new AvailabilityStrategy();
        }

        if ("WEDDING".equalsIgnoreCase(sessionType)) {
            return new SpecializationStrategy();
        }

        return new ExperienceStrategy();
    }
}
