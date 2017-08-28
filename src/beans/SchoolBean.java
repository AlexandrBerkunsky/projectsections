package beans;

import dao.DistrictDAO;
import dao.SchoolDAO;
import tables.District;
import tables.School;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SchoolBean implements Serializable {
    @EJB
    SchoolDAO schoolDAO;

    @EJB
    DistrictDAO districtDAO;

    private boolean edit = false;

    private boolean schooladd = false;

    public boolean isSchooladd() {
        return schooladd;
    }

    public boolean isEdit() {
        return edit;
    }

    @Inject
    CommonUtils util;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    private School school = new School();

    public List<School> getSchools() {
        return schoolDAO.findAll();
    }

    public void add(DistrictBean districtBean) {
        District district = districtDAO.find(districtBean.getDistrict().getId());
        school.setDistrict(district);
        schoolDAO.add(school);
        district.getSchools().add(school);
        districtDAO.save(district);
        districtBean.setDistrict(district);
        school = new School();
        schooladd = false;

        util.redirectWithGet();
    }

    public void showadd() {
        schooladd = true;

        util.redirectWithGet();
    }

    public void saveEdit() {
        schoolDAO.save(school);
        this.school = new School();
        edit = false;

        util.redirectWithGet();
    }

    public void cancelEdit() {
        this.school = new School();
        schooladd = false;
        edit = false;


        util.redirectWithGet();
    }

    public void editSchool(School school) {
        this.school = school;
        schooladd = false;
        edit = true;

        util.redirectWithGet();
    }

    public void delete(School school,  DistrictBean districtBean) {
        schoolDAO.delete(school.getId());
//        districtBean.setDistrict(districtDAO.find(districtBean.getDistrict().getId()));
        districtBean.getDistrict().getSchools().remove(school);
        districtDAO.save(districtBean.getDistrict());

        util.redirectWithGet();
    }
}
