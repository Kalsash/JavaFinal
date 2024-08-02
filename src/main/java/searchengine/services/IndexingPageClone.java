package searchengine.services;

import lombok.NoArgsConstructor;
import searchengine.model.Page;
import searchengine.controllers.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class IndexingPageClone {
    PageRepository pageRepository;

    @Autowired
    public IndexingPageClone(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public void partiallyCloneTargetIndexingPage(Page targetPage, Page searchPage){
        for(Page page : pageRepository.findAll()){
            if(page.compareTo(searchPage) == 0){
                targetPage.setId(page.getId());
                targetPage.setPath(page.getPath());
                targetPage.setSiteId(page.getSiteId());
                break;
            }
        }
    }

}
