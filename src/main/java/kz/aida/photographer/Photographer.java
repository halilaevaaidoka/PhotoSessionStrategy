package kz.aida.photographer;

public class Photographer {

    private final String name;
    private final int experience;
    private final int availableInHours;
    private final String specialization;

    public Photographer(String name, int experience,
                        int availableInHours, String specialization) {
        this.name = name;
        this.experience = experience;
        this.availableInHours = availableInHours;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getAvailableInHours() {
        return availableInHours;
    }

    public String getSpecialization() {
        return specialization;
    }
}
