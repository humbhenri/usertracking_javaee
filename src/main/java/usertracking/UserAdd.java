package usertracking;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import usertracking.dao.UserDAO;
import usertracking.model.User;

@Named
@RequestScoped
public class UserAdd {

    @Inject
    private UserDAO userDAO;

    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String submit() {
        User user = new User();
        user.setBirthDate(birthday);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userDAO.save(user);
        return "index";
    }
}
