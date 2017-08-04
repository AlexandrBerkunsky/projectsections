package dao;

import beans.DistrictBean;
import tables.District;
import tables.School;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SchoolDAO {
    @PersistenceContext
    EntityManager em;

    public List<School> findAll() { return em.createNamedQuery("School.FindAll").getResultList(); }


    public void add(School school) {
        em.persist(school);
    }

    public void save(School school) {
        em.merge(school);
    }

    public void delete(int id) {
        School school = em.find(School.class, id);
        System.out.println("дошел");
        em.remove(school);

        System.out.println("прошел");
    }

    public School find(int id) {
        return em.find(School.class, id);
    }
}
