package stud.summits.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "summit_alps")
@ToString(of = {"id", "lastName", "firstName", "middleName", "ascentDate"})
@EqualsAndHashCode(of = {"id"})
public class SummitAlps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "ascent_date")
    private Date ascentDate;

    // Note: do not create getters and setters for parent entity or it will create infinite recursion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "summit_id")
    private Summit summit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getAscentDate() {
        return ascentDate;
    }

    public void setAscentDate(Date ascentDate) {
        this.ascentDate = ascentDate;
    }
}
