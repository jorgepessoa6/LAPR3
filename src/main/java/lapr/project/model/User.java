package lapr.project.model;

import java.util.Objects;

/**
 * @author Jorge Pessoa
 */
public class User {

    // Instance Variables
    //---------------------------------------------------------------------
    private String email;
    private String username;
    private int height;
    private int weight;
    private int points;
    private double averageSpeed;
    private int visaCardNumber;
    private String password;
    private String gender;

    // Constructors
    //---------------------------------------------------------------------
    public User() {
        //empty constructor
    }

    public User(String email, String username, int height, int weight, int points, String gender, double averageSpeed, int visaCardNumber, String password) {
        this.email = email;
        this.username = username;
        this.height = height;
        this.weight = weight;
        this.points = points;
        setGender(gender);
        this.averageSpeed = averageSpeed;
        this.visaCardNumber = visaCardNumber;
        this.password = password;
    }

    // Getters & Setters
    //---------------------------------------------------------------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public int getVisaCardNumber() {
        return visaCardNumber;
    }

    public void setVisaCardNumber(int visaCardNumber) {
        this.visaCardNumber = visaCardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        switch (gender.toUpperCase()) {
            case "F":
                this.gender = "F";
                break;
            default:
                this.gender = "M";
        }
    }

    // Equals, hashCode & toString
    //---------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return height == user.height
                && weight == user.weight
                && Double.compare(user.averageSpeed, averageSpeed) == 0
                && visaCardNumber == user.visaCardNumber
                && Objects.equals(email, user.email)
                && Objects.equals(username, user.username)
                && Objects.equals(password, user.password)
                && Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, username, height, weight, averageSpeed, visaCardNumber, password,gender);
    }

    @Override
    public String toString() {
        return "User{"
                + "email='" + email + '\''
                + ", username='" + username + '\''
                + ", height=" + height
                + ", weight=" + weight
                + ", averageSpeed=" + averageSpeed
                + ", visaCardNumber=" + visaCardNumber
                + ", password='" + password + '\''
                + ", gender=" + gender
                + '}';
    }
}
