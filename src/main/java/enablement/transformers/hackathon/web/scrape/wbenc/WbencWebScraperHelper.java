package enablement.transformers.hackathon.web.scrape.wbenc;

import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;

public interface WbencWebScraperHelper {

    public String getLeaderName() throws IOException;

    public String getOrgUrl() throws IOException;

    public void getProfileDetails(WebClient clientProfile, String strProfileUrl, Wbenc wbenc) throws IOException;

    public String getStates(String strLocations);

    public String getContacts(String strLocations);

    public String getRole(String strRole);

    public String getPersonEmail(String strPersonalEmail);
}
