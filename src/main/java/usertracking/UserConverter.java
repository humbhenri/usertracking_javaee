package usertracking;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import usertracking.dao.UserDAO;
import usertracking.model.User;

@Named
public class UserConverter implements Converter {

    @Inject
    private UserDAO userDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        int id = Integer.parseInt(value);
        return userDAO.findById(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Integer id = ((User) value).getId();

        return (id != null) ? id.toString() : null;
    }

}
