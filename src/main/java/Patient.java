public class Patient implements Billable{
    private String name;
    private int age;
    private int numberOfSessions;
    private double pricePerSession;
    private boolean isActive;
    private int painLevel;

    public boolean hasHighPriority(){
        return isActive && painLevel >= 7;
    }

    public void updatePainLevel(int newPainLevel){
        if (newPainLevel < 0 || newPainLevel > 10){
            throw new IllegalArgumentException("Pain level must be between 0 and 10");
        } else {
        painLevel = newPainLevel;
        }
    }

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

    PainLevel getPainCategory(){
        if (painLevel <=3){
            return PainLevel.LOW;
        } else if (painLevel <=6){
            return PainLevel.MODERATE;
        } else {
            return PainLevel.HIGH;
        }
    }
    @Override
    public double calculateTotalTreatmentCost(){
        return pricePerSession * numberOfSessions;
    }

    public Patient(String name, int age, int numberOfSessions,
                   double pricePerSession, boolean isActive, int painLevel) {
        this.name = name;
        this.age = age;
        this.numberOfSessions = numberOfSessions;
        this.pricePerSession = pricePerSession;
        this.isActive = isActive;
        updatePainLevel(painLevel);
    }
}
