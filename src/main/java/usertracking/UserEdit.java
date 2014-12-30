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
public class UserEdit implements Serializable {

    @Inject
    private Conversation conversation;

    @Inject
    private UserDAO userDAO;

    private User user;

    @PostConstruct
    public void init() {
        conversation.begin();
    }

    public String submit() {
        userDAO.save(user);
        conversation.end();
        return "index?faces-redirect=true";
    }

    public void preRenderView() {
        if (user == null) {
            user = new User();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
