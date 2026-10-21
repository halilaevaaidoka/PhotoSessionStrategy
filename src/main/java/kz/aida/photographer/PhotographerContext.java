package kz.aida.photographer;

import java.util.List;

public class PhotographerContext {

    private PhotographerStrategy strategy;

    public PhotographerContext(PhotographerStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PhotographerStrategy strategy) {
        this.strategy = strategy;
    }

    public Photographer selectPhotographer(
            List<Photographer> photographers,
            String sessionType) {

        return strategy.selectPhotographer(
                photographers, sessionType);
    }
}
