package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "Teacher.FindAll", query = "select t from Teacher t")
})
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    private String name2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    @Basic
    private String education;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    private String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Basic
    private String expierence;

    public String getExpierence() {
        return expierence;
    }

    public void setExpierence(String expierence) {
        this.expierence = expierence;
    }

    @OneToMany(mappedBy = "teacher")
    private Collection<Section> sections;

    public Collection<Section> getSections() {
        return sections;
    }

    public void setSections(Collection<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return surname+" "+name.charAt(0)+"."+name2.charAt(0)+".";
    }
}
