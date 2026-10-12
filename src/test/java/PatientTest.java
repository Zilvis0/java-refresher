import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

public class PatientTest {

    @Test
    void shouldCalculateTreatmentCost() {
        Patient patient = new Patient("Anna", 42, 9, 55, true, 7);

        assertEquals(495.0, patient.calculateTotalTreatmentCost());
    }

    @Test
    void shouldRejectInvalidPainLevel() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Patient("Bob", 35, 10, 55, true, 15);
        });
    }

    @Test
    void shouldUpdatePainLevel(){
        Patient patient =  new Patient("Anna", 7, 1, 50, true, 7);
        patient.updatePainLevel(3);
        assertEquals(3, patient.getPainLevel());
    }

    @Test
    void shouldRejectInvalidPainLevelUpdate(){
        Patient patient =  new Patient("Anna", 7, 1, 50, true, 7);
        assertThrows(IllegalArgumentException.class, () -> {
            patient.updatePainLevel(15);
        });
        assertEquals(7, patient.getPainLevel());
    }

    @Test
    void shouldAcceptBoundaryPainLevels() {
        Patient patient =  new Patient("Anna", 7, 1, 50, true, 7);
        patient.updatePainLevel(0);
        assertEquals(0, patient.getPainLevel());
        patient.updatePainLevel(10);
        assertEquals(10, patient.getPainLevel());
    }

    @Test
    void shouldRejectOutOfRangePainLevels() {
        Patient patient =  new Patient("Anna", 7, 1, 50, true, 7);
        assertThrows(IllegalArgumentException.class, () -> {patient.updatePainLevel(-1);});
        assertThrows(IllegalArgumentException.class, () -> {patient.updatePainLevel(11);});
        assertEquals(7, patient.getPainLevel());
    }

    @Test
    void shouldIdentifyHighPriorityPatients(){
        Patient patient1 =  new Patient("Anna", 7, 1, 50, true, 8);
        Patient patient2 =  new Patient("Bnna", 7, 1, 50, true, 4);
        Patient patient3 =  new Patient("Cnna", 7, 1, 50, false, 9);
        assertTrue(patient1.hasHighPriority());
        assertFalse(patient2.hasHighPriority());
        assertFalse(patient3.hasHighPriority());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 6, 7, 10})
    void shouldAcceptValidPainLevels(int painLevel) {
        Patient patient = new Patient("Anna", 7, 1, 50, true, painLevel);
        assertEquals(painLevel, patient.getPainLevel());
    }

    @ParameterizedTest
    @CsvSource({
            "true, 8, true",
            "true, 4, false",
            "false, 9, false",
            "true, 7, true",
            "true, 6, false"
    })
    void shouldDeterminePriority(boolean active, int painLevel, boolean expected) {
        Patient patient = new Patient("Anna", 7, 1, 50, active, painLevel);
        assertEquals(expected, patient.hasHighPriority());
    }
}
