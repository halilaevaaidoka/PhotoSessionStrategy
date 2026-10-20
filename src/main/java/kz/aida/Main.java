
package kz.aida;

public class Main {

    public static double calculatePrice(
            String type, int hours, double distance) {

        if (type.equals("HOURLY")) {
            return hours * 10000;

        } else if (type.equals("PACKAGE")) {
            return hours <= 2 ? 18000 : 18000 + (hours - 2) * 8000;

        } else if (type.equals("DISTANCE")) {
            return hours * 10000 + distance * 500;
        }

        throw new IllegalArgumentException("Unknown pricing type");
    }

    public static void main(String[] args) {

        System.out.println("=== PHOTO SESSION PRICING ===");

        System.out.println("Hourly: " +
                calculatePrice("HOURLY", 2, 10));

        System.out.println("Package: " +
                calculatePrice("PACKAGE", 2, 10));

        System.out.println("Distance: " +
                calculatePrice("DISTANCE", 2, 10));
    }
}
