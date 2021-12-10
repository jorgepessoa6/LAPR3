/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rickropes
 */
public class UserTest {

    public UserTest() {
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        String expResult = "a@a.a";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "b@b.b";
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals("a@a.a", instance.getEmail());
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        String expResult = "u1";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "u2";
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals("u1", instance.getUsername());
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        int height = 1;
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals(0, instance.getHeight());
        instance.setHeight(height);
        assertEquals(height, instance.getHeight());
    }

    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        int expResult = 1;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        int weight = 0;
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals(1, instance.getWeight());
        instance.setWeight(weight);
        assertEquals(weight, instance.getWeight());
    }

    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        int expResult = 0;
        int result = instance.getPoints();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals(0, instance.getPoints());
        instance.setPoints(1);
        assertEquals(1, instance.getPoints());
    }

    @Test
    public void testGetAverageSpeed() {
        System.out.println("getAverageSpeed");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        double expResult = 3.0;
        double result = instance.getAverageSpeed();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetAverageSpeed() {
        System.out.println("setAverageSpeed");
        double averageSpeed = 0.0;
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals(3d, instance.getAverageSpeed(), 0.0);
        instance.setAverageSpeed(averageSpeed);
        assertEquals(averageSpeed, instance.getAverageSpeed(), 0.0);
    }

    @Test
    public void testGetVisaCardNumber() {
        System.out.println("getVisaCardNumber");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        int expResult = 4;
        int result = instance.getVisaCardNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetVisaCardNumber() {
        System.out.println("setVisaCardNumber");
        int visaCardNumber = 0;
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals(4, instance.getVisaCardNumber());
        instance.setVisaCardNumber(visaCardNumber);
        assertEquals(visaCardNumber, instance.getVisaCardNumber());
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        String expResult = "a";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "b";
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals("a", instance.getPassword());
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        String expResult = "M";
        String result = instance.getGender();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "F";
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        assertEquals("M", instance.getGender());
        instance.setGender(gender);
        assertEquals("F", instance.getGender());
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        User user1 = new User();
        User user2 = new User();
        User user3 = new User("a@a.a", "u1", 0, 1, 0, "M", 1.0, 4, "a");
        User user4 = new User("a@a.a", "u1", 0, 1, 0, "M", 1.0, 4, "a");
        User user5 = new User("a", "u1", 0, 1, 0, "M", 1.0, 4, "a");
        User user6 = new User("a@a.a", "1", 0, 1, 0, "M", 1.0, 4, "a");
        User user7 = new User("a@a.a", "u1", 10, 1, 0, "M", 1.0, 4, "a");
        User user8 = new User("a@a.a", "u1", 0, 11, 0, "M", 1.0, 4, "a");
        User user9 = new User("a@a.a", "u1", 0, 1, 0, "F", 1.0, 4, "a");
        User user10 = new User("a@a.a", "u1", 0, 1, 0, "M", 1.2, 4, "a");
        User user11 = new User("a@a.a", "u1", 0, 1, 0, "M", 1.0, 1, "a");
        User user12 = new User("a@a.a", "u1", 0, 1, 0, "M", 1.0, 4, "password");
        Path path = new Path();

        assertEquals(user1, user2);
        assertEquals(user2, user2);
        assertEquals(user4, user3);
        assertNotEquals(user1, user3);
        assertNotEquals(user4, user5);
        assertNotEquals(user4, user6);
        assertNotEquals(user4, user7);
        assertNotEquals(user4, user8);
        assertNotEquals(user4, user9);
        assertNotEquals(user4, user10);
        assertNotEquals(user4, user11);
        assertNotEquals(user4, user12);
        assertNotEquals(user1, null);
        assertNotEquals(user1, path);
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        User instance2 = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        User user = new User();
        assertEquals(instance2.hashCode(), instance.hashCode());
        assertNotEquals(user.hashCode(), instance.hashCode());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User("a@a.a", "u1", 0, 1, 0, "M", 3d, 4, "a");
        String expResult = "User{email='a@a.a', username='u1', height=0, weight=1, averageSpeed=3.0, visaCardNumber=4, password='a', gender=M}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
