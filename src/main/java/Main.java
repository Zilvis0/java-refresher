import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        double clinicRevenue = 0;
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Anna", 42, 9, 55, true, 7));
        patients.add(new Patient("Peter", 31, 4, 60, true, 3));
        patients.add(new Patient("Maria", 67, 12, 55, false, 8));

        for (Patient patient : patients){
            clinicRevenue += patient.calculateTotalTreatmentCost();
            System.out.println(patient.getName() + " -> " + patient.getPainDescription());
        }
        System.out.println("Total clinic revenue: " + clinicRevenue + " CHF");
    }

}
