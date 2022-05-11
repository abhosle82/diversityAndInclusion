package enablement.transformers.hackathon.web.scrape.wbenc;
public class WbencWebScraperConstants {
    public static final String WBENC_URL = "https://www.wbenc.org/about-wbenc/leadership-council/";
    public static final String INIT_PATH = "//div[@class='four-col-padding']";
    public static final String LEADER_PATH = "./a/div/div[@class='popup-title']";
    public static final String ORG_PATH = "./a";
    public static final String PROFILE_INIT_PATH = "//div[@class='two-long-left-cols rpo-content-left']";
    public static final String ORG_NAME_PATH = "./h2";
    public static final String ABOUT_ORG_NAME_PATH ="./p";
    public static final String LOCATION_PATH = "./div[@class='rpo-info']/div[@class='two-cols']";
    public static final String EMAIL_PATH = "./div[@class='rpo-info']/div[@class='two-cols'][2]";


}
