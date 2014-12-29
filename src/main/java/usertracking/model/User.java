package usertracking.model;

import java.util.Date;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;

    public User(String firstName, String lastName, String email, Date birthDate) {
        super();
        this.setFirstName(firstName);
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
