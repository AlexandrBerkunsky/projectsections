package beans;

import dao.ProfileDAO;
import dao.SchoolDAO;
import model.ReportProfilesBySchoolLine;
import tables.Profile;
import tables.School;
import tables.Section;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    @EJB
    private SchoolDAO schoolDAO;

    @EJB
    private ProfileDAO profileDAO;

    private School school;

    private String login;
    private String password;

    private String message;

    public String getMessage() {
        return message;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String check() {
        school = schoolDAO.findByLogin(login, password);
        if (school != null) {
            message = null;
            return "cabinetschool";
        } else {
            message = "Логін або пароль не знайдено!";
            return null;
        }
    }

    public String getSchoolNameUpperCase() {
        String schoolName = school.getName();
        return schoolName.toUpperCase();
    }

    public List<ReportProfilesBySchoolLine> getReportProfilesBySchoolLines(){
        List<ReportProfilesBySchoolLine> lines = new ArrayList<>();
        List<Profile> profiles = profileDAO.findAll();
        int count = 0;
        int sumSections = 0;
        int sumStudents = 0;
        double sumHours = 0;
        for (Profile profile : profiles) {
            count++;
            double countHours = 0;
            int countSections = 0;
            int countStudents = 0;
            for (Section section : school.getSections()) {
                if (section.getProfile().equals(profile)) {
                    countHours+=section.getHours();
                    countSections++;
                    countStudents+=section.getStudents();
                }
            }
            sumSections+=countSections;
            sumStudents+=countStudents;
            sumHours+=countHours;
            lines.add(new ReportProfilesBySchoolLine(String.valueOf(count),profile.getName(),countSections,countHours,countStudents));
        }
        lines.add(new ReportProfilesBySchoolLine("","ВСЬОГО:", sumSections,sumHours,sumStudents));
        return lines;
    }
}
