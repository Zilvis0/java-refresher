import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PatientRegistryTest {

    @Test
    void shouldReturnTrueWhenIdIsNotUsed(){
        int id = 101;
        HashMap<Integer, Patient> patientRegistry = new HashMap<>();
        assertTrue(Main.addPatient(patientRegistry, id, new Patient("Robert", 31, 4, 60, true, 5)));
        assertTrue(patientRegistry.containsKey(id));
    }

    @Test
    void shouldReturnFalseWhenIdIsUsed(){
        int id = 101;
        HashMap<Integer, Patient> patientRegistry = new HashMap<>();
        Main.addPatient(patientRegistry, id, new Patient("Robert", 31, 4, 60, true, 5));
        assertFalse(Main.addPatient(patientRegistry, id, new Patient("Bobert", 31, 4, 60, true, 5)));
        assertEquals("Robert", patientRegistry.get(id).getName());
    }

}
