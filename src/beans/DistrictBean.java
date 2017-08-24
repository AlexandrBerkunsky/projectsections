package beans;


import dao.DistrictDAO;
import tables.District;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DistrictBean implements Serializable {
    @EJB
    DistrictDAO districtDAO;

    private boolean edit = false;

    public boolean isEdit() {
        return edit;
    }

    @Inject
    CommonUtils util;

    private District district = new District();

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<District> getDistricts() {
        return districtDAO.findAll();
    }



    public void delete(int id) {
        districtDAO.delete(id);

        util.redirectWithGet();
    }

    public void add() {
        districtDAO.add(district);
        district = new District();

        util.redirectWithGet();
    }

    public String showSchools(District d) {
        district = d;
        return "schoolsbydistrict";
    }

    public void editDistrict(District district) {
        this.district = district;
        edit = true;

        util.redirectWithGet();
    }

    public void saveEdit() {
        districtDAO.save(district);
        this.district = new District();
        edit = false;

        util.redirectWithGet();
    }

    public void cancelEdit() {
        this.district = new District();
        edit = false;

        util.redirectWithGet();
    }
}
