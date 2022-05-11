package enablement.transformers.hackathon.web.scrape;

import enablement.transformers.hackathon.web.scrape.wbenc.Wbenc;


import java.util.List;

public interface DandIWebscraper {
    public void setupConnection();
    public List<Wbenc> scrapeDiversityAndInclusionData();
}
