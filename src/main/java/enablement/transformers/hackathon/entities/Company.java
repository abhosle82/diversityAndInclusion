package enablement.transformers.hackathon.entities;

import enablement.transformers.hackathon.entities.Leader;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="company_diversity_info")
public class Company {

    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String companyName;
    private String companyDescription;

    @OneToMany
    @JoinTable(
            name = "company_diversity_info_leaders",
            joinColumns = @JoinColumn(name = "COMPANY_ID"),
            inverseJoinColumns = @JoinColumn(name = "LEADER_ID")
    )
    private Set<Leader> leaders;

    private String mobileNumber;
    private String emailId;
    private String urls;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Set<Leader> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<Leader> leaders) {
        this.leaders = leaders;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}
