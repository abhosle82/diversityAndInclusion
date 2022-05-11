package enablement.transformers.hackathon.web.scrape;

import enablement.transformers.hackathon.web.scrape.DandIWebscraper;
import enablement.transformers.hackathon.web.scrape.wbenc.WbencWebScraper;

public class DandIWebscraperFactory {
    public static DandIWebscraper createDandIWebScraper(String strWebScraper){
        if("WBENC".equals(strWebScraper)){
            return new WbencWebScraper();
        }
        return null;
    }
}
