package dao;

import tables.District;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DistrictDAO {
    @PersistenceContext
    EntityManager em;

    public List<District> findAll(){
        return em.createNamedQuery("District.FindAll").getResultList();
    }

    public void add(District district) {
        em.persist(district);
    }

    public void delete(int id) {
        District district = em.find(District.class, id);
        em.remove(district);
    }

    public void save(District district) {
        em.merge(district);
    }

    public District find(int id) {
        return em.find(District.class, id);
    }
}
