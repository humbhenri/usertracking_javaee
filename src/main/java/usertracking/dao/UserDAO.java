package usertracking.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import usertracking.model.User;

public class UserDAO {

    @Inject
    private EntityManager em;

    public void save(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return em.createQuery("from User").getResultList();
    }

    public void delete(User user) {
        em.getTransaction().begin();
        Query q = em.createQuery("delete from User where id = :id");
        q.setParameter("id", user.getId());
        q.executeUpdate();
        em.getTransaction().commit();
    }

}