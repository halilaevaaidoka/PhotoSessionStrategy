package kz.aida.photographer;

import java.util.List;

public interface PhotographerStrategy {
    Photographer selectPhotographer(
            List<Photographer> photographers,
            String sessionType);
}
