public class Main {
    String name;
    int age;
    int numberOfSessions;
    double pricePerSession;
    boolean isActive = true;
    int painLevel;

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

    public static void main(String[] args){
        Main patient = new Main();
        patient.name = "Anna";
        patient.age = 42;
        patient.numberOfSessions = 9;
        patient.pricePerSession = 55;
        patient.painLevel = 7;
        System.out.println("Name: " + patient.name);
        System.out.println("Age: " +patient.age);
        System.out.println("Sessions: " +patient.numberOfSessions);
        System.out.println("Price: " +patient.pricePerSession);
        System.out.println("Is active: " +patient.isActive);
        if(patient.isActive && patient.painLevel >= 7){
            System.out.println("Treatment priority: High");
        }

        String description = patient.getPainDescription();
        System.out.println(description);

        double totalCost = patient.calculateTotalTreatmentCost();
        System.out.println("Total treatment cost: " + totalCost + "CHF");
    }
}
