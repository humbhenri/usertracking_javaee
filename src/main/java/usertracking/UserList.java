package usertracking;

import java.text.ParseException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import usertracking.dao.UserDAO;
import usertracking.model.User;

@Named
@RequestScoped
public class UserList {

    @Inject
    private UserDAO userDAO;

    public List<User> getUsers() throws ParseException {
        return userDAO.findAll();
    }
}
