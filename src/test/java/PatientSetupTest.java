import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientSetupTest{

    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient("Anna", 42, 1, 50, true, 7);
    }

    @Test
    void shouldUpdatePainLevel(){
        patient.updatePainLevel(3);
        assertEquals(3, patient.getPainLevel());
    }

    @Test
    void shouldStartWithOriginalPainLevel(){
     assertEquals(7, patient.getPainLevel());
    }
}
