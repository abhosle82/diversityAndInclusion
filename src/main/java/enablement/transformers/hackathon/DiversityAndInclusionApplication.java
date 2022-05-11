package enablement.transformers.hackathon;

import enablement.transformers.hackathon.entities.DiversityAndInclusion;
import enablement.transformers.hackathon.services.DiversityAndInclusionService;
import enablement.transformers.hackathon.web.scrape.DandIWebscraper;
import enablement.transformers.hackathon.web.scrape.DandIWebscraperFactory;
import enablement.transformers.hackathon.web.scrape.wbenc.Wbenc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DiversityAndInclusionApplication implements CommandLineRunner {

    @Autowired
    private DiversityAndInclusionService service;

    public static void main(String[] args) {
        SpringApplication.run(DiversityAndInclusionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       DandIWebscraper webScraper = DandIWebscraperFactory.createDandIWebScraper("WBENC");
       webScraper.setupConnection();
       List<DiversityAndInclusion> lsDAndI =  service.generateDiversityAndInclusionData(webScraper.scrapeDiversityAndInclusionData());
        System.out.println("size::::"+lsDAndI.size());
       service.saveDiversityAndInclusionData(lsDAndI);
    }
}
