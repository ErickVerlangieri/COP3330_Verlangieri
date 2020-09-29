import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BodyMassIndexTest {
    @Test
    void BodyMassIndexTest(){

        BodyMassIndex BMI = new BodyMassIndex(71, 150);
        assertEquals(20.92, BMI.math(71, 150));

        BodyMassIndex category1 = new BodyMassIndex(75, 140);
        assertEquals("Underweight", category1.response);

        BodyMassIndex category2 = new BodyMassIndex(70, 140);
        assertEquals("Normal weight", category2.response);

        BodyMassIndex category3 = new BodyMassIndex(60, 140);
        assertEquals("Overweight", category3.response);

        BodyMassIndex category4 = new BodyMassIndex(50, 140);
        assertEquals("Obesity", category4.response);

    }

}
