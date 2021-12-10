package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    void getIdPath() {
        Path path = new Path();
        path.setIdPath(1);
        assertEquals(path.getIdPath(), 1);
    }

    @Test
    void setIdPath() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setIdPath(2);
        assertEquals(path.getIdPath(), 2);
    }

    @Test
    void getLatitudeA() {
        Path path = new Path();
        path.setLatitudeA(1);
        assertEquals(path.getLatitudeA(), 1);
    }

    @Test
    void setLatitudeA() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setLatitudeA(2);
        assertEquals(path.getLatitudeA(), 2);
    }

    @Test
    void getLongitudeA() {
        Path path = new Path();
        path.setLongitudeA(1);
        assertEquals(path.getLongitudeA(), 1);
    }

    @Test
    void setLongitudeA() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setLongitudeA(2);
        assertEquals(path.getLongitudeA(), 2);
    }

    @Test
    void getLatitudeB() {
        Path path = new Path();
        path.setLatitudeB(1);
        assertEquals(path.getLatitudeB(), 1);
    }

    @Test
    void setLatitudeB() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setLatitudeB(2);
        assertEquals(path.getLatitudeB(), 2);
    }

    @Test
    void getLongitudeB() {
        Path path = new Path();
        path.setLongitudeB(1);
        assertEquals(path.getLongitudeB(), 1);
    }

    @Test
    void setLongitudeB() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setLongitudeB(2);
        assertEquals(path.getLongitudeB(), 2);
    }

    @Test
    void getKineticCoefficient() {
        Path path = new Path();
        path.setKineticCoefficient(1);
        assertEquals(path.getKineticCoefficient(), 1);
    }

    @Test
    void setKineticCoefficient() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setKineticCoefficient(2);
        assertEquals(path.getKineticCoefficient(), 2);
    }

    @Test
    void getWindDirection() {
        Path path = new Path();
        path.setWindDirection(1);
        assertEquals(path.getWindDirection(), 1);
    }

    @Test
    void setWindDirection() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setWindDirection(2);
        assertEquals(path.getWindDirection(), 2);
    }

    @Test
    void getWindSpeed() {
        Path path = new Path();
        path.setWindSpeed(1);
        assertEquals(path.getWindSpeed(), 1);
    }

    @Test
    void setWindSpeed() {
        Path path = new Path(1,1,1,1,1,1,1,1);
        path.setWindSpeed(2);
        assertEquals(path.getWindSpeed(), 2);
    }

    @Test
    void testEquals() {
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path(1,1.2,1.2,1.2,1.2,1.2,1.2,1.2);
        Path path4 = new Path(1,1.2,1.2,1.2,1.2,1.2,1.2,1.2);
        Path path5 = new Path(1,1.3,1.3,1.3,1.3,1.3,1.3,1.3);
        Path path6 = new Path(1,1.2,1.3,1.2,1.2,1.2,1.2,1.2);
        Path path7 = new Path(1,1.2,1.2,1.3,1.2,1.2,1.2,1.2);
        Path path8 = new Path(1,1.2,1.2,1.2,1.3,1.2,1.2,1.2);
        Path path9 = new Path(1,1.2,1.2,1.2,1.2,1.3,1.2,1.2);
        Path path10 = new Path(1,1.2,1.2,1.2,1.2,1.2,1.3,1.2);
        Path path11 = new Path(1,1.2,1.2,1.2,1.2,1.2,1.2,1.3);
        User user = new User();
        assertEquals(path1, path2);
        assertEquals(path2, path2);
        assertEquals(path4, path3);
        assertNotEquals(path1, path3);
        assertNotEquals(path4, path5);
        assertNotEquals(path4, path6);
        assertNotEquals(path4, path7);
        assertNotEquals(path4, path8);
        assertNotEquals(path4, path9);
        assertNotEquals(path4, path10);
        assertNotEquals(path4, path11);
        assertNotEquals(path1, null);
        assertNotEquals(path1, user);
    }

    @Test
    void testHashCode() {
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path(1,1,1,1,1,1,1,1);
        User user = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals(path1.hashCode(), path2.hashCode());
        assertEquals(path2.hashCode(), path2.hashCode());
        assertNotEquals(path1.hashCode(), path3.hashCode());
        assertNotEquals(path1.hashCode(), user.hashCode());
    }

    @Test
    void testToString() {
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path(1,1,1,1,1,1,1,1);
        User user = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");

        assertEquals(path1.toString(), path2.toString());
        assertEquals(path2.toString(), path2.toString());
        assertNotEquals(path1.toString(), path3.toString());
        assertNotEquals(path1.toString(), user.toString());
    }
}