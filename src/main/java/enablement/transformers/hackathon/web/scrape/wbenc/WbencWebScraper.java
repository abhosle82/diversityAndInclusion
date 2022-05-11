package enablement.transformers.hackathon.web.scrape.wbenc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import enablement.transformers.hackathon.util.WebClientUtil;
import enablement.transformers.hackathon.web.scrape.DandIWebscraper;

import java.util.ArrayList;
import java.util.List;

public class WbencWebScraper implements DandIWebscraper {

    private WebClient client;

    @Override
    public void setupConnection() {
        this.client = WebClientUtil.getInstance();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
    }

    @Override
    public List<Wbenc> scrapeDiversityAndInclusionData() {
        Wbenc wbenc = new Wbenc();
        List<Wbenc> listOfWebnc=new ArrayList<>();
        try(WebClient webClient= client) {
            String baseUrl = WbencWebScraperConstants.WBENC_URL;
            HtmlPage page = client.getPage(baseUrl);
            List<HtmlElement> itemList = page.getByXPath(WbencWebScraperConstants.INIT_PATH);
            if (itemList.isEmpty()) {
                System.out.println("No item found");
            } else {
                for (HtmlElement htmlItem : itemList) {
                    if(htmlItem.getFirstByXPath(WbencWebScraperConstants.LEADER_PATH)!=null) {
                        String strLeaderName = ((HtmlElement) htmlItem.getFirstByXPath(WbencWebScraperConstants.LEADER_PATH)).asNormalizedText();
                        wbenc.setLeaderName(strLeaderName);
                        String url = ((HtmlAnchor) htmlItem.getFirstByXPath(WbencWebScraperConstants.ORG_PATH)).getHrefAttribute();
                        wbenc.setUrl(url);
                        System.out.println("Leader Name:::" + strLeaderName);
                        System.out.println("URL:::" + url);
                        WbencWebScraperHelper helper = new WbencWebScraperHelperImpl();
                        helper.getProfileDetails(client,url,wbenc);
                        listOfWebnc.add(wbenc);
                        System.out.println("----------------------------------------------");
                        //break;
                    }
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //System.out.println("1:"+listOfWebnc.get(0).getLeaderName()+":"+listOfWebnc.get(0).getEmail()+":"+listOfWebnc.get(0).getContacts()+":"+listOfWebnc.get(0).getAboutOrg());
            client.close();
        }
        return listOfWebnc;
    }
}
