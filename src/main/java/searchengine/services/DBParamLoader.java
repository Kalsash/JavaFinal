package searchengine.services;

import lombok.NoArgsConstructor;
import searchengine.model.StartParamList;
import searchengine.controllers.FieldRepository;
import searchengine.controllers.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DBParamLoader {
    SiteRepository siteRepository;
    FieldRepository fieldRepository;
    StartParamList startParamList;

    @Autowired
    public DBParamLoader(SiteRepository siteRepository, FieldRepository fieldRepository, StartParamList startParamList) {
        this.siteRepository = siteRepository;
        this.fieldRepository = fieldRepository;
        this.startParamList = startParamList;
    }

    public void loadStartParam(){
        fieldRepository.saveAll(startParamList.getField());
        siteRepository.saveAll(startParamList.getSites());
    }

}
