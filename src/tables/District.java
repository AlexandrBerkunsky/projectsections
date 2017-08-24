package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "District.FindAll", query = "select d from District d")
})
public class District {
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
    @Column(length = 20)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "district")
    private Collection<School> schools;

    public Collection<School> getSchools() {
        return schools;
    }

    public void setSchools(Collection<School> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return name;
    }
}
