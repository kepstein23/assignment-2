import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FlightSimulatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testPlanesNull() {
        FlightSimulator.simulateFlights(null, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegSteps() {
        Airplane[] planes = new Airplane[1];
        planes[0] = new Airplane(1, 1, 90, 10);
        FlightSimulator.simulateFlights(planes, -1, 0);
    }

    @Test
    public void test1Steps() {
        Airplane[] planes = new Airplane[1];
        planes[0] = new Airplane(1, 1, 90, 10);
        assertTrue(FlightSimulator.simulateFlights(planes, 1, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegDistance() {
        Airplane[] planes = new Airplane[1];
        planes[0] = new Airplane(1, 1, 90, 10);
        FlightSimulator.simulateFlights(planes, 2, -1);
    }

    @Test
    public void testZeroDistance() {
        Airplane[] planes = new Airplane[1];
        planes[0] = new Airplane(1, 1, 90, 10);
        assertTrue(FlightSimulator.simulateFlights(planes, 2, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHasNullPlane() {
        Airplane[] planes = {null};
        FlightSimulator.simulateFlights(planes, 2, 1);
    }

    @Test
    public void testZeroVelocity() {
        Airplane[] planes = new Airplane[1];
        planes[0] = new Airplane(1, 1, 90, 0);
        FlightSimulator.simulateFlights(planes, 2, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testBadVelocity() {
        Airplane[] planes = new Airplane[1];
        planes[0] = new Airplane(1, 1, 90, -1);
        FlightSimulator.simulateFlights(planes, 2, 1);
    }

    @Test
    public void testCollide() {
        Airplane[] planes = new Airplane[2];
        planes[0] = new Airplane(1, 2, 90, 10);
        planes[1] = new Airplane(1, 2, 270, 10);
        assertFalse(FlightSimulator.simulateFlights(planes, 2, 1));
    }
    
    @Test
    public void testNoCollide() {
        Airplane[] planes = new Airplane[2];
        planes[0] = new Airplane(1, 2, 90, 10);
        planes[1] = new Airplane(1, 1, 270, 10);
        assertTrue(FlightSimulator.simulateFlights(planes, 2, 1));
    }
    
    @Test
    public void testEqualSafeDistance() {
        Airplane[] planes = new Airplane[2];
        planes[0] = new Airplane(1, 1, 90, 10);
        planes[1] = new Airplane(1, 2, 270, 10);
        assertTrue(FlightSimulator.simulateFlights(planes, 2, 1));
    }
}
