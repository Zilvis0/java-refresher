import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        double clinicRevenue = 0;
        double billableClinicRevenue = 0;
        int highPriorityPatients = 0;
        double avgPainLvl;
        int totalPainLvl = 0;

        GroupTherapy group = new GroupTherapy("Back Training", 6, 25);

        ArrayList<Patient> patients = new ArrayList<>();

        patients.add(new Patient("Anna", 42, 9, 55, true, 7));
        patients.add(new Patient("Peter", 31, 4, 60, true, 3));
        patients.add(new Patient("Maria", 67, 12, 55, false, 8));
//        patients.get(1).updatePainLevel(8);
//        patients.get(1).updatePainLevel(15);

        ArrayList<Billable> billableItems = new ArrayList<>();

        billableItems.add(patients.get(0));
        billableItems.add(group);

        for (Billable billableItem : billableItems){
            billableClinicRevenue += billableItem.calculateTotalTreatmentCost();
        }
        System.out.println("Combined revenue: " + billableClinicRevenue + " CHF");


        try{
            Patient testPatient = new Patient("Bob", 35, 10, 55, true, 47);
        } catch(IllegalArgumentException e){
            System.out.println("Could not create patient: " +  e.getMessage());
        }

        for (Patient patient : patients){
            if (patient.hasHighPriority()){
                highPriorityPatients++;
            }
            totalPainLvl+=patient.getPainLevel();
            clinicRevenue += patient.calculateTotalTreatmentCost();
            System.out.println(patient.getName() + " -> " + patient.getPainCategory() + (patient.hasHighPriority() ? " -> HIGH PRIORITY" : ""));
        }
        avgPainLvl = (double) totalPainLvl / patients.size();
        System.out.println("Total clinic revenue: " + clinicRevenue + " CHF");
        System.out.println("High priority patients: " + highPriorityPatients);
        System.out.println("Average pain level: " + avgPainLvl);
        System.out.println("Group therapy revenue: " + group.calculateTotalTreatmentCost() + " CHF");
    }

}
