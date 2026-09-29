public class Patient {
    private String name;
    private int age;
    private int numberOfSessions;
    private double pricePerSession;
    private boolean isActive;
    private int painLevel;

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getNumberOfSessions(){
        return numberOfSessions;
    }

    public double getPricePerSession(){
        return pricePerSession;
    }
    public boolean isActive(){
        return isActive;
    }

    public int getPainLevel(){
        return painLevel;
    }

    String getPainDescription(){
        if (painLevel < 0 || painLevel > 10) {
            return "Invalid pain level";
        } else if (painLevel <=3){
            return "Low pain";
        } else if (painLevel <=6){
            return "Moderate pain";
        } else {
            return "High pain";
        }
    }
    double calculateTotalTreatmentCost(){
        return pricePerSession * numberOfSessions;
    }

    public Patient(String name, int age, int numberOfSessions,
                   double pricePerSession, boolean isActive, int painLevel) {
        this.name = name;
        this.age = age;
        this.numberOfSessions = numberOfSessions;
        this.pricePerSession = pricePerSession;
        this.isActive = isActive;
        this.painLevel = painLevel;
    }
}
