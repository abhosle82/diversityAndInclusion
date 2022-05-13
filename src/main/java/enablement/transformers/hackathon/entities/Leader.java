package enablement.transformers.hackathon.entities;


import javax.persistence.*;

@Entity
@Table(name="tbl_div_leader")
public class Leader {

    @Id
    @Column(name = "LEADER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /*@ManyToOne
    @JoinTable(name = "company_diversity_info_leaders",
            joinColumns = @JoinColumn(name = "LEADER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID")
    )*/
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    private String name;

    private String companyName;
    private String mobileNumber;
    private String emailId;
    private String gender;
    private String isLgbt;
    private String isVeteran;
    private String isDisable;
    private String nationality;
    private String religion;
    private String maritialStatus;
    private String politicalOrientation;
    private String color;
    private String language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsLgbt() {
        return isLgbt;
    }

    public void setIsLgbt(String isLgbt) {
        this.isLgbt = isLgbt;
    }

    public String getIsVeteran() {
        return isVeteran;
    }

    public void setIsVeteran(String isVeteran) {
        this.isVeteran = isVeteran;
    }

    public String getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(String isDisable) {
        this.isDisable = isDisable;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMaritialStatus() {
        return maritialStatus;
    }

    public void setMaritialStatus(String maritialStatus) {
        this.maritialStatus = maritialStatus;
    }

    public String getPoliticalOrientation() {
        return politicalOrientation;
    }

    public void setPoliticalOrientation(String politicalOrientation) {
        this.politicalOrientation = politicalOrientation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
