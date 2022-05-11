package enablement.transformers.hackathon.services;

import enablement.transformers.hackathon.entities.DiversityAndInclusion;
import enablement.transformers.hackathon.web.scrape.wbenc.Wbenc;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiversityAndInclusionService {
    public void saveDiversityAndInclusionData(List<DiversityAndInclusion> lsDAndI);

    public List<DiversityAndInclusion> generateDiversityAndInclusionData(List<Wbenc> lsWebnc);
}
