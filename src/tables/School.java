package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "School.FindAll", query = "select s from School s"),
        @NamedQuery(name = "School.FindByLogin", query = "select s from School s where s.login = :login and s.password = :password")
})
public class School {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;



    @Basic
    private String fullname;

    @Basic
    private String address;
    @Basic
    private String email;

    @Basic
    private String edrpou;

    @Basic
    @Column(length = 13)
    private String shortname;

    @Basic
    private String name;

    @Basic
    private String phone;

    @Basic
    private int countcabinets;

    @Basic
    private String director;

    @Basic
    private String login;

    @Basic
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }


    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCountcabinets() {
        return countcabinets;
    }

    public void setCountcabinets(int countcabinets) {
        this.countcabinets = countcabinets;
    }


    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
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

    @ManyToOne(optional = false)
    private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @OneToMany(mappedBy = "school")
    private Collection<Section> sections;

    public Collection<Section> getSections() {
        return sections;
    }

    public void setSections(Collection<Section> sections) {
        this.sections = sections;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;

        School school = (School) o;

        if (getId() != school.getId()) return false;
        if (getCountcabinets() != school.getCountcabinets()) return false;
        if (getFullname() != null ? !getFullname().equals(school.getFullname()) : school.getFullname() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(school.getAddress()) : school.getAddress() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(school.getEmail()) : school.getEmail() != null) return false;
        if (getEdrpou() != null ? !getEdrpou().equals(school.getEdrpou()) : school.getEdrpou() != null) return false;
        if (getShortname() != null ? !getShortname().equals(school.getShortname()) : school.getShortname() != null)
            return false;
        if (getName() != null ? !getName().equals(school.getName()) : school.getName() != null) return false;
        if (getPhone() != null ? !getPhone().equals(school.getPhone()) : school.getPhone() != null) return false;
        if (getDirector() != null ? !getDirector().equals(school.getDirector()) : school.getDirector() != null)
            return false;
        if (getLogin() != null ? !getLogin().equals(school.getLogin()) : school.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(school.getPassword()) : school.getPassword() != null)
            return false;
        if (getDistrict() != null ? !getDistrict().equals(school.getDistrict()) : school.getDistrict() != null)
            return false;
        return getSections() != null ? getSections().equals(school.getSections()) : school.getSections() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getFullname() != null ? getFullname().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getEdrpou() != null ? getEdrpou().hashCode() : 0);
        result = 31 * result + (getShortname() != null ? getShortname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + getCountcabinets();
        result = 31 * result + (getDirector() != null ? getDirector().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getDistrict() != null ? getDistrict().hashCode() : 0);
        result = 31 * result + (getSections() != null ? getSections().hashCode() : 0);
        return result;
    }
}
