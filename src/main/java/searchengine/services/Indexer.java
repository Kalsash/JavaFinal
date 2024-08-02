package searchengine.services;

import lombok.NoArgsConstructor;
import searchengine.model.Index;
import searchengine.model.Lemma;
import searchengine.model.Site;
import searchengine.controllers.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
@NoArgsConstructor
public class Indexer {

    SiteRepository siteRepository;

    @Autowired
    public Indexer(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public ArrayList<Index> getIndexes(TreeMap<Integer, TreeMap<Lemma, Float>> lemmasResult, HashMap<String, Lemma> lemmasResultToDB){
        ArrayList<Index> result = new ArrayList<>();
        Site targetSite;
        for(Map.Entry<Integer, TreeMap<Lemma, Float>> page : lemmasResult.entrySet()){
            for (Map.Entry<Lemma, Float> entry : page.getValue().entrySet()){
                result.add(new Index(page.getKey(), lemmasResultToDB.get(entry.getKey().getLemma()).getId(), entry.getValue()));
                targetSite = siteRepository.findById(entry.getKey().getSiteId()).get();
                targetSite.setStatusTime(LocalDateTime.now());
                siteRepository.save(targetSite);
            }
        }
        return result;
    }

}
