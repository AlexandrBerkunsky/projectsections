package dao;

import tables.Profile;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProfileDAO {
    @PersistenceContext
    EntityManager em;

    public List<Profile> findAll() {
        return em.createNamedQuery("Profile.FindAll").getResultList();
    }

    public void save(Profile profile) {
        em.merge(profile);
    }

    public void add(Profile profile) {
        em.persist(profile);
    }

    public Profile find(int id) {
        return em.find(Profile.class, id);
    }

    public void delete(int id) {
        Profile profile = em.find(Profile.class, id);
        em.remove(profile);
    }
}
