package kz.aida.pricing;

public class FixedDistanceProvider implements DistanceProvider {

    @Override
    public double getDistanceKm() {
        return 10.0;
    }
}
