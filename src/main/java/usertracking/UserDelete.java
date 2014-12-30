package usertracking;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import usertracking.dao.UserDAO;
import usertracking.model.User;

@Named
@ConversationScoped
public class UserDelete implements Serializable {
    private User user;

    @Inject
    private UserDAO userDAO;

    @Inject
    private Conversation conversation;

    @PostConstruct
    public void init() {
        conversation.begin();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String delete() {
        userDAO.delete(user);
        conversation.end();
        return "index?faces-redirect=true";
    }

}
