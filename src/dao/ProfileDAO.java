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
}
