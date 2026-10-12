import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GroupTherapyTest {

    @ParameterizedTest
    @CsvSource({
            "a, 6, 25, 150",
            "b, 0, 25, 0",
    })
    void shouldCalculateGroupTherapyRevenue(String name, int participants, double pricePerPerson, double expectedSum){
        GroupTherapy gt = new GroupTherapy(name, participants, pricePerPerson);
        assertEquals(expectedSum, gt.calculateTotalTreatmentCost());
    }

    @Test
    void shouldRejectNegativeParticipantsAndPrices(){
        assertThrows(IllegalArgumentException.class, () -> {new GroupTherapy("a", -1, 25);});
        assertThrows(IllegalArgumentException.class, () -> {new GroupTherapy("a", 1, -25);});
    }
}
