package beans;

import dao.ProfileDAO;
import tables.Profile;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProfileBean implements Serializable {
    @EJB
    ProfileDAO profileDAO;

    private boolean edit = false;

    public boolean isProfileadd() {
        return profileadd;
    }

    private boolean profileadd = false;

    public boolean isEdit() {
        return edit;
    }

    @Inject
    CommonUtils util;

    private Profile profile = new Profile();

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Profile> getProfiles() {
        return profileDAO.findAll();
    }

    public void showadd() {
        profileadd = true;

        util.redirectWithGet();
    }

    public void saveEdit() {
        profileDAO.save(profile);
        this.profile = new Profile();
        edit = false;

        util.redirectWithGet();
    }

    public void cancelEdit() {
        this.profile = new Profile();
        profileadd = false;
        edit = false;

        util.redirectWithGet();
    }

    public void delete(int id) {
        profileDAO.delete(id);

        util.redirectWithGet();
    }
}
