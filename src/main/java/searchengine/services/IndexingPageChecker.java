package searchengine.services;


import lombok.NoArgsConstructor;
import searchengine.model.Site;
import searchengine.controllers.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class IndexingPageChecker {

    SiteRepository siteRepository;

    @Autowired
    public IndexingPageChecker(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public boolean indexingPageInRange(String url){
        for(Site site : siteRepository.findAll()) {
            if (url.matches(site.getUrl() + ".*")) {
                return true;
            }
        }
        return false;
    }
}
