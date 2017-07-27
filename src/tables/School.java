package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
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
}
