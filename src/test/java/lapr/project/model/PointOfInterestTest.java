package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointOfInterestTest {

    @Test
    void getLatitude() {
        Poi pointOfInterest = new Poi();
        pointOfInterest.setLatitude(1);
        assertEquals(pointOfInterest.getLatitude(), 1);
    }

    @Test
    void setLatitude() {
        Poi pointOfInterest = new Poi(1,1,1,"a");
        pointOfInterest.setLatitude(2);
        assertEquals(pointOfInterest.getLatitude(), 2);
    }

    @Test
    void getLongitude() {
        Poi pointOfInterest = new Poi();
        pointOfInterest.setLongitude(1);
        assertEquals(pointOfInterest.getLongitude(), 1);
    }

    @Test
    void setLongitude() {
        Poi pointOfInterest = new Poi(1,1,1,"a");
        pointOfInterest.setLongitude(2);
        assertEquals(pointOfInterest.getLongitude(), 2);
    }

    @Test
    void getElevation() {
        Poi pointOfInterest = new Poi();
        pointOfInterest.setElevation(1);
        assertEquals(pointOfInterest.getElevation(), 1);
    }

    @Test
    void setElevation() {
        Poi pointOfInterest = new Poi(1,1,1,"a");
        pointOfInterest.setElevation(2);
        assertEquals(pointOfInterest.getElevation(), 2);
    }

    @Test
    void getDescription() {
        Poi pointOfInterest = new Poi();
        pointOfInterest.setDescription("a");
        assertEquals(pointOfInterest.getDescription(), "a");
    }

    @Test
    void setDescription() {
        Poi pointOfInterest = new Poi(1,1,1,"a");
        pointOfInterest.setDescription("b");
        assertEquals(pointOfInterest.getDescription(), "b");
    }

    @Test
    void testEquals() {
        Poi pointOfInterest1 = new Poi();
        Poi pointOfInterest2 = new Poi();
        Poi pointOfInterest3 = new Poi(1.0,1.0,1,"a");
        Poi pointOfInterest4 = new Poi(1.0,1.0,1,"a");
        Poi pointOfInterest6 = new Poi(1.1,1.0,1,"a");
        Poi pointOfInterest7 = new Poi(1.0,1.1,1,"a");
        Poi pointOfInterest8 = new Poi(1.0,1.0,2,"a");
        Poi pointOfInterest9 = new Poi(1.0,1.0,1,"b");
        User user = new User();

        assertEquals(pointOfInterest1, pointOfInterest2);
        assertEquals(pointOfInterest2, pointOfInterest2);
        assertEquals(pointOfInterest3, pointOfInterest4);
        assertNotEquals(pointOfInterest1, pointOfInterest3);
        assertNotEquals(pointOfInterest4, pointOfInterest6);
        assertNotEquals(pointOfInterest4, pointOfInterest7);
        assertNotEquals(pointOfInterest4, pointOfInterest8);
        assertNotEquals(pointOfInterest4, pointOfInterest9);
        assertNotEquals(pointOfInterest1, null);
        assertNotEquals(pointOfInterest1, user);
    }

    @Test
    void testHashCode() {
        Poi pointOfInterest1 = new Poi();
        Poi pointOfInterest2 = new Poi();
        Poi pointOfInterest3 = new Poi(1.0,1.0,1,"a");
        User user = new User();

        assertEquals(pointOfInterest1.hashCode(), pointOfInterest2.hashCode());
        assertEquals(pointOfInterest2.hashCode(), pointOfInterest2.hashCode());
        assertNotEquals(pointOfInterest1.hashCode(), pointOfInterest3.hashCode());
        assertNotEquals(pointOfInterest1.hashCode(), user.hashCode());
    }

    @Test
    void testToString() {
        Poi pointOfInterest1 = new Poi();
        Poi pointOfInterest2 = new Poi();
        Poi pointOfInterest3 = new Poi(1.0,1.0,1,"a");
        User user = new User();

        assertEquals(pointOfInterest1.toString(), pointOfInterest2.toString());
        assertEquals(pointOfInterest2.toString(), pointOfInterest2.toString());
        assertNotEquals(pointOfInterest1.toString(), pointOfInterest3.toString());
        assertNotEquals(pointOfInterest1.toString(), user.toString());
    }
}