import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


}
