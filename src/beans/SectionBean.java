package beans;

import dao.DistrictDAO;
import dao.ProfileDAO;
import dao.SectionDAO;
import dao.TeacherDAO;
import tables.*;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class SectionBean implements Serializable {
    @EJB
    SectionDAO sectionDAO;

    @EJB
    ProfileDAO profileDAO;

    @EJB
    TeacherDAO teacherDAO;

    @EJB
    DistrictDAO distictDAO;

    @Inject
    CommonUtils util;

    @Inject
    LoginBean loginBean;



    private boolean edit = false;
    private boolean sectionadd = false;

    private Teacher teacher;

    private int profileId;

    private List<Section> filteredSections;

    public List<Section> getFilteredSections() {
        return filteredSections;
    }

    public void setFilteredSections(List<Section> filteredSections) {
        this.filteredSections = filteredSections;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

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

        Profile profile = profileDAO.find(profileId);
        section.setProfile(profile);
        section.setTeacher(teacher);
        School school = loginBean.getSchool();
        section.setSchool(school);
        sectionDAO.add(section);
        section = new Section();
        sectionadd = false;

        util.redirectWithGet();
    }

    public void saveEdit() {
        sectionDAO.save(section);
        this.section = new Section();
        edit = false;
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

    public void editSection(Section section) {
        this.section = section;
        edit = true;
        sectionadd = false;

        util.redirectWithGet();
    }

    public void delete(int id) {
        sectionDAO.delete(id);

        util.redirectWithGet();
    }



    public List<Teacher> completeTeacher(String query){
        return teacherDAO.findAll()
                .stream()
                .filter(t->t.toString().contains(query))
                .collect(Collectors.toList());


    }
}
