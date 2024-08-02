package searchengine.services;

import lombok.NoArgsConstructor;
import searchengine.model.Lemma;
import searchengine.controllers.LemmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.HashMap;

@Component
@NoArgsConstructor
public class LemmasFrequencyReducer {

    LemmaRepository lemmaRepository;

    @Autowired
    public LemmasFrequencyReducer(LemmaRepository lemmaRepository) {
        this.lemmaRepository = lemmaRepository;
    }

    public void reduceLemmasFrequency(HashMap<String, Lemma> existingLemmas ){
        existingLemmas.forEach((lemmaName, lemma) -> {
            lemma.decreaseFrequency();
            lemmaRepository.save(lemma);
            if(lemma.getFrequency() <= 0){
                lemmaRepository.deleteById(lemma.getId());
            }
        });
    }
}
