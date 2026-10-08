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
}
