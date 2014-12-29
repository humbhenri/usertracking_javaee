package usertracking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import usertracking.model.User;

@ManagedBean
public class UserList {

    public List<User> getUsers() throws ParseException {
        List<User> users = new ArrayList<User>();
        User u = new User("Humberto", "Pinheiro", "humbhenri@gmail.com",
                new SimpleDateFormat("dd/MM/yy").parse("04/05/1985"));
        users.add(u);
        return users;
    }
}
