package beans;

import dao.SchoolDAO;
import tables.School;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    @EJB
    private SchoolDAO schoolDAO;

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
}
