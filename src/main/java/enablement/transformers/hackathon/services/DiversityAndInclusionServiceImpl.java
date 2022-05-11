package enablement.transformers.hackathon.services;

import enablement.transformers.hackathon.entities.DiversityAndInclusion;
import enablement.transformers.hackathon.repositories.DiversityAndInclusionRepository;
import enablement.transformers.hackathon.web.scrape.wbenc.Wbenc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class DiversityAndInclusionServiceImpl implements DiversityAndInclusionService{

    @Autowired
    private DiversityAndInclusionRepository repository;

    @Override
    @Transactional
    public void saveDiversityAndInclusionData(List<DiversityAndInclusion> lsDAndI) {
            System.out.println("insert loop");
            repository.saveAll(lsDAndI);
            System.out.println("Inserted successfully......");
    }

    @Override
    public List<DiversityAndInclusion> generateDiversityAndInclusionData(List<Wbenc> lsWebnc) {
        List<DiversityAndInclusion> lsDiversityAndInclusion = new ArrayList<>();
        DiversityAndInclusion objDiversityAndInclusion = new DiversityAndInclusion();
        for(Wbenc wbenc: lsWebnc){
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
