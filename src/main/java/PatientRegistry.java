import java.util.HashMap;



public class PatientRegistry {

    private HashMap<Integer, Patient> patients;

    public PatientRegistry(){
        patients = new HashMap<>();
    }

    public boolean addPatient(int id, Patient patient){
        return patients.putIfAbsent(id, patient) == null;
    }

    public Patient getPatient(int id){
      return patients.get(id);
    }

    public boolean removePatient(int id) {

        return patients.remove(id) != null;
    };

}
