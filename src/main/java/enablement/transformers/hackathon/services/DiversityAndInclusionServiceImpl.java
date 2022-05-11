package enablement.transformers.hackathon.services;

import enablement.transformers.hackathon.entities.Company;
import enablement.transformers.hackathon.entities.DiversityAndInclusion;
import enablement.transformers.hackathon.entities.Leader;
import enablement.transformers.hackathon.repositories.CompanyRepository;
import enablement.transformers.hackathon.repositories.DiversityAndInclusionRepository;
import enablement.transformers.hackathon.repositories.LeaderRepository;
import enablement.transformers.hackathon.web.scrape.wbenc.Wbenc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiversityAndInclusionServiceImpl implements DiversityAndInclusionService{

    @Autowired
    private CompanyRepository companyrepository;

    @Autowired
    private LeaderRepository leaderRepository;



    @Override
    @Transactional
    public void saveDiversityAndInclusionData(List<DiversityAndInclusion> lsDAndI) {
        List<Company> lsCompany = new ArrayList<>();
        List<Leader> lsLeader = new ArrayList<>();
        Set<Leader> setOfLeaders = new HashSet<>();
        for(DiversityAndInclusion diversityAndInclusion: lsDAndI){
            Leader leader = new Leader();
            leader.setCompanyName(diversityAndInclusion.getOrgName());
            leader.setEmailId(diversityAndInclusion.getEmail());
            leader.setMobileNumber(diversityAndInclusion.getContacts());
            leader.setName(diversityAndInclusion.getLeaderName());
            lsLeader.add(leader);

            Company company = new Company();
            company.setCompanyName(diversityAndInclusion.getOrgName());
            company.setCompanyDescription(diversityAndInclusion.getAboutOrg());
            company.setEmailId(diversityAndInclusion.getContacts());
            company.setUrls(diversityAndInclusion.getUrl());
            company.setMobileNumber(diversityAndInclusion.getContacts());
            setOfLeaders.add(leader);
            company.setLeaders(setOfLeaders);
            lsCompany.add(company);
        }
        companyrepository.saveAll(lsCompany);
        leaderRepository.saveAll(lsLeader);

        System.out.println("Inserted successfully......");
    }

    public List<Company> getCompanies(List<DiversityAndInclusion> lsDAndI){
        List<Company> lsCompany = new ArrayList<Company>();
        List<Leader> lsLeader = new ArrayList<Leader>();
        Set<Leader> setOfLeaders = new HashSet<>();
        for(DiversityAndInclusion diversityAndInclusion: lsDAndI){
            Leader leader = new Leader();
            leader.setCompanyName(diversityAndInclusion.getOrgName());
            leader.setEmailId(diversityAndInclusion.getEmail());
            leader.setMobileNumber(diversityAndInclusion.getContacts());
            leader.setName(diversityAndInclusion.getLeaderName());
            setOfLeaders.add(leader);
            lsLeader.add(leader);
        }
        for(DiversityAndInclusion diversityAndInclusion: lsDAndI) {
            Company company = new Company();
            company.setCompanyName(diversityAndInclusion.getOrgName());
            company.setEmailId(diversityAndInclusion.getContacts());
            company.setUrls(diversityAndInclusion.getUrl());
            company.setMobileNumber(diversityAndInclusion.getContacts());
            company.setLeaders(setOfLeaders);
        }

        return null;
    }

    @Override
    public List<DiversityAndInclusion> generateDiversityAndInclusionData(List<Wbenc> lsWebnc) {
        List<DiversityAndInclusion> lsDiversityAndInclusion = new ArrayList<>();
        for(Wbenc wbenc: lsWebnc){
            DiversityAndInclusion objDiversityAndInclusion = new DiversityAndInclusion();
            System.out.println("loop::");
            objDiversityAndInclusion.setLeaderName(wbenc.getLeaderName());
            objDiversityAndInclusion.setOrgName(wbenc.getOrgName());
            objDiversityAndInclusion.setUrl(wbenc.getUrl());
            objDiversityAndInclusion.setRole(wbenc.getRole());
            objDiversityAndInclusion.setAboutOrg(wbenc.getAboutOrg());
            objDiversityAndInclusion.setStates(wbenc.getStates());
            objDiversityAndInclusion.setEmail(wbenc.getEmail());
            objDiversityAndInclusion.setContacts(wbenc.getContacts());
            lsDiversityAndInclusion.add(objDiversityAndInclusion);
        }
        return lsDiversityAndInclusion;
    }
}
