package usertracking.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    @Produces
    @ApplicationScoped
    public EntityManagerFactory criaEMF() {
        return Persistence.createEntityManagerFactory("default");
    }

    @Produces
    @RequestScoped
    public EntityManager criaEM(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }

    public void fechaEM(@Disposes
    EntityManager em) {
        em.close();
    }
}
