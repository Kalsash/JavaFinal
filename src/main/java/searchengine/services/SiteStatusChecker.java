package searchengine.services;
import lombok.NoArgsConstructor;
import searchengine.model.Site;
import searchengine.model.Status;
import searchengine.controllers.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SiteStatusChecker {
    SiteRepository siteRepository;

    @Autowired
    public SiteStatusChecker(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public boolean indexingSitesExist(){
        for (Site site : siteRepository.findAll()) {
            if (site.getStatus().equals(Status.INDEXING)) {
                return true;
            }
        }
        return false;
    }

    public boolean indexedSitesExist(){
        for (Site site : siteRepository.findAll()) {
            if (site.getStatus().equals(Status.INDEXED)) {
                return true;
            }
        }
        return false;
    }

}
