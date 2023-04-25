package dat.backend.entities;

import dat.backend.model.entities.RunningCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
This class contains tests for every method in the RunningCalculator class.
 */

public class RunningCalculatorTest {

    private double distance;
    private int time;
    private double speed;

    //Before every test - variables are reset to default values.
    @BeforeEach
    void setupClass(){
        distance = 10.0;
        time = 60;
        speed = 10.0;
    }

    /*
    Test checks the following:
    Correct calculation with regular numbers.
    Correct calculation with decimal numbers.
    Correct handling of invalid arguments.
     */
    @Test
    void calculateDistanceTest(){
        assertEquals(10.0, RunningCalculator.calculateDistance(time, speed));
        time = 15;
        speed = 9.25;
        assertEquals(2.312, RunningCalculator.calculateDistance(time, speed), 0.01);
        time = 0;
        assertThrows(IllegalArgumentException.class, () -> RunningCalculator.calculateDistance(time, speed));
    }

    /*
    Test checks the following:
    Correct calculation with regular numbers.
    Correct calculation with decimal numbers.
    Correct handling of invalid arguments.
     */
    @Test
    void calculateTimeTest(){
        assertEquals(60, RunningCalculator.calculateTime(distance, speed));
        distance = 2.312;
        speed = 9.25;
        assertEquals(15, RunningCalculator.calculateTime(distance, speed), 0.01);
        distance = -15;
        assertThrows(IllegalArgumentException.class, () -> RunningCalculator.calculateTime(distance, speed));
    }

    /*
    Test checks the following:
    Correct calculation with regular numbers.
    Correct calculation with decimal numbers.
    Correct handling of invalid arguments.
     */
    @Test
    void calculateSpeedTest(){
        assertEquals(10.0, RunningCalculator.calculateSpeed(distance, time));
        distance = 2.312;
        time = 15;
        assertEquals(9.25, RunningCalculator.calculateSpeed(distance, time), 0.01);
        time = 0;
        assertThrows(IllegalArgumentException.class, () -> RunningCalculator.calculateSpeed(distance, time));
    }

}
