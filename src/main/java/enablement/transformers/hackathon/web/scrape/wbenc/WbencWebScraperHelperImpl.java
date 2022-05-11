package enablement.transformers.hackathon.web.scrape.wbenc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

public class WbencWebScraperHelperImpl implements WbencWebScraperHelper{

    @Override
    public String getLeaderName() throws IOException {
        return null;
    }

    @Override
    public String getOrgUrl() throws IOException {
        return null;
    }

    @Override
    public Wbenc getProfileDetails(WebClient clientProfile, String strProfileUrl,Wbenc wbenc) throws IOException {
        HtmlPage page = clientProfile.getPage(strProfileUrl);
        //List<HtmlElement> itemList = page.getByXPath("//div[@class='two-long-left-cols rpo-content-left']");
        List<HtmlElement> itemList = page.getByXPath(WbencWebScraperConstants.PROFILE_INIT_PATH);
        if (itemList.isEmpty()) {
            System.out.println("No item found");
        } else {
            for (HtmlElement htmlItem : itemList) {
                String strOrganizationName = ((HtmlElement) htmlItem.getFirstByXPath(WbencWebScraperConstants.ORG_NAME_PATH)).asNormalizedText();
                wbenc.setOrgName(strOrganizationName);
                String strAboutOrganization = ((HtmlElement) htmlItem.getFirstByXPath(WbencWebScraperConstants.ABOUT_ORG_NAME_PATH)).asNormalizedText();
                wbenc.setAboutOrg(strAboutOrganization);

                String strLocations = ((HtmlElement) htmlItem.getFirstByXPath(WbencWebScraperConstants.LOCATION_PATH)).asNormalizedText().replace("\n","$");
                String strRoleAndEmail = ((HtmlElement) htmlItem.getFirstByXPath(WbencWebScraperConstants.EMAIL_PATH)).asNormalizedText().replace("\n","$");
                String strRole = getRole(strRoleAndEmail);
                wbenc.setRole(strRole);

                String strPersonalEmail = getPersonEmail(strRoleAndEmail);
                wbenc.setEmail(strPersonalEmail);

                String strStates = getStates(strLocations);
                wbenc.setStates(strStates);

                String strContacts = getContacts(strLocations);
                wbenc.setContacts(strContacts);

                System.out.println("Organization Name:"+wbenc.getOrgName());
                System.out.println("Role :"+wbenc.getRole());
                System.out.println("About Organization :"+wbenc.getAboutOrg().replace("\n",""));
                System.out.println("States :"+wbenc.getStates());
                System.out.println("Email :"+wbenc.getStates());
                System.out.println("Contacts:"+wbenc.getContacts());

            }
        }
        return wbenc;

    }

    @Override
    public String getStates(String strLocations) {
        final String[] split = strLocations.split("\\$");
        if(split!=null && split.length == 5){
            return split[1];
        }
        return null;
    }

    @Override
    public String getContacts(String strLocations) {
        final String[] split = strLocations.split("\\$");
        if(split!=null && split.length == 5){
            return "Email:".concat(split[3]).concat(", Phone: ").concat(split[4]);
        }
        return null;
    }

    @Override
    public String getRole(String strRole) {
        final String[] split = strRole.split("\\$");
        if(split!=null && split.length==4){
            return split[2];
        }
        return null;
    }

    @Override
    public String getPersonEmail(String strPersonalEmail) {
        final String[] split = strPersonalEmail.split("\\$");
        if(split!=null && split.length==4){
            return split[3];
        }
        return null;
    }
}
