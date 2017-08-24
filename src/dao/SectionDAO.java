package dao;

import tables.Section;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SectionDAO {
    @PersistenceContext
    EntityManager em;

    public List<Section> findAll() {
        return em.createNamedQuery("Section.FindAll").getResultList();
    }

    public void save(Section section) {
        em.merge(section);
    }


    public void add(Section section) {
        em.persist(section);
    }

    public void delete(int id) {
        Section section = em.find(Section.class, id);
        em.remove(section);
    }

    public Section find(int id) {
        return em.find(Section.class, id);
    }
}
