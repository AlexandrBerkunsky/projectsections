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

    private Boolean edit;

    @Inject
    CommonUtils utils;

    private District district = new District();

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<District> getDistricts() {
        //TODO не понятно, скопировали
        return districtDAO.findAll();
    }
}
