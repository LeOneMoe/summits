package stud.summits.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "summit_names")
@ToString(of = {"id", "summitName"})
@EqualsAndHashCode(of = {"id"})
public class SummitName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "summit_name")
    private String summitName;

    // Warning: DO NOT create getters and setters for parent entity or it will trigger infinite recursion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "summit_id") // name of the foreign key column
    private Summit summit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummitName() {
        return summitName;
    }

    public void setSummitName(String summitName) {
        this.summitName = summitName;
    }
}
