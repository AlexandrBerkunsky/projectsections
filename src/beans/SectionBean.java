package beans;

import dao.SectionDAO;
import tables.Section;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SectionBean implements Serializable {
    @EJB
    SectionDAO sectionDAO;

    @Inject
    CommonUtils util;

    private boolean edit = false;
    private boolean sectionadd = false;

    private Section section = new Section();

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<Section> getSections() {
        return sectionDAO.findAll();
    }

    public boolean isEdit() {
        return edit;
    }

    public boolean isSectionadd() {
        return sectionadd;
    }

    public void add() {
        sectionDAO.add(section);
        section = new Section();
        sectionadd = false;

        util.redirectWithGet();
    }

    public void cancelEdit() {
        this.section = new Section();
        edit = false;
        sectionadd = false;

        util.redirectWithGet();
    }

    public void showadd() {
        sectionadd = true;
        edit = false;

        util.redirectWithGet();
    }
}
