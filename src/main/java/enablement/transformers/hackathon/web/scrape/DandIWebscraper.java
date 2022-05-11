package enablement.transformers.hackathon.web.scrape;

import com.gargoylesoftware.htmlunit.WebClient;
import enablement.transformers.hackathon.web.scrape.wbenc.Wbenc;


import java.io.IOException;
import java.util.List;

public interface DandIWebscraper {
    public void setupConnection();
    public List<Wbenc> scrapeDiversityAndInclusionData();
}
