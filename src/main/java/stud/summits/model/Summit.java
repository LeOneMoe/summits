package stud.summits.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "summit")
@ToString(of = {"id", "mainland" , "latitude", "longitude", "height", "summitNames", "summitAlps"})
@EqualsAndHashCode(of = {"id"})
public class Summit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mainland;

    private int latitude;

    private int longitude;

    private int height;

    @OneToMany(mappedBy = "summit")
    private List<SummitName> summitNames;

    @OneToMany(mappedBy = "summit")
    private List<SummitAlps> summitAlps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainland() {
        return mainland;
    }

    public void setMainland(String mainland) {
        this.mainland = mainland;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<SummitName> getSummitNames() {
        return summitNames;
    }

    public void setSummitNames(List<SummitName> summitNames) {
        this.summitNames = summitNames;
    }

    public List<SummitAlps> getSummitAlps() {
        return summitAlps;
    }

    public void setSummitAlps(List<SummitAlps> summitAlps) {
        this.summitAlps = summitAlps;
    }
}
