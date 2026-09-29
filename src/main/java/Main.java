public class Main {
    public static void main(String[] args){
        Patient patient = new Patient();
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " +patient.getAge());
        System.out.println("Sessions: " +patient.getNumberOfSessions());
        System.out.println("Price: " +patient.getPricePerSession());
        System.out.println("Is active: " +patient.isActive());
        if(patient.isActive() && patient.getPainLevel() >= 7){
            System.out.println("Treatment priority: High");
        }

        String description = patient.getPainDescription();
        System.out.println(description);

        double totalCost = patient.calculateTotalTreatmentCost();
        System.out.println("Total treatment cost: " + totalCost + "CHF");
    }
}
