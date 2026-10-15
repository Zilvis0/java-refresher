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

    @Test
    void shouldAddAndRetrievePatient(){
        PatientRegistry patientRegistry = new PatientRegistry();
        Patient test =  new Patient("Anna", 42, 9, 55, true, 7);
        patientRegistry.addPatient(101, test);
        assertSame(test, patientRegistry.getPatient(101));
    }

    @Test
    void shouldRejectDuplicateId(){
        PatientRegistry patientRegistry = new PatientRegistry();
        Patient test =  new Patient("Anna", 42, 9, 55, true, 7);
        Patient test2 =  new Patient("Peter", 31, 4, 60, true, 3);
        patientRegistry.addPatient(101, test);
        assertFalse(patientRegistry.addPatient(101, test2));
        assertSame(test, patientRegistry.getPatient(101));

    }

    @Test
    void shouldReturnNullForUnknownId(){
        PatientRegistry patientRegistry = new PatientRegistry();
       assertNull(patientRegistry.getPatient(999));

    }

    @Test
    void shouldRemoveExistingPatient(){
        PatientRegistry patientRegistry = new PatientRegistry();
        Patient test =  new Patient("Anna", 42, 9, 55, true, 7);
        patientRegistry.addPatient(101, test);
        assertTrue(patientRegistry.removePatient(101));
        assertNull(patientRegistry.getPatient(101));

    }

    @Test
    void shouldReturnFalseWhenRemovingUnknownPatient(){
        PatientRegistry patientRegistry = new PatientRegistry();
        assertFalse(patientRegistry.removePatient(999));
    }

}
