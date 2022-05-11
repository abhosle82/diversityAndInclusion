package enablement.transformers.hackathon.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Diversity_Inclusion")
public class DiversityAndInclusion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="LEADER_NAME")
    private String leaderName;

    @Column(name="URL")
    private String url;

    @Column(name="ORGANIZATION_NAME")
    private String orgName;

    @Column(name="ROLE")
    private String role;

    @Column(name="ABOUT_ORGANIZATION")
    private String aboutOrg;

    @Column(name="STATES")
    private String states;

    @Column(name="EMAIL")
    private String email;

    @Column(name="CONTACTS")
    private String contacts;

    public DiversityAndInclusion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAboutOrg() {
        return aboutOrg;
    }

    public void setAboutOrg(String aboutOrg) {
        this.aboutOrg = aboutOrg;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiversityAndInclusion that = (DiversityAndInclusion) o;
        return Objects.equals(id, that.id) && Objects.equals(leaderName, that.leaderName) && Objects.equals(url, that.url) && Objects.equals(orgName, that.orgName) && Objects.equals(role, that.role) && Objects.equals(aboutOrg, that.aboutOrg) && Objects.equals(states, that.states) && Objects.equals(email, that.email) && Objects.equals(contacts, that.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leaderName, url, orgName, role, aboutOrg, states, email, contacts);
    }
}
