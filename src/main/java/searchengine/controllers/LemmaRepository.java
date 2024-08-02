package searchengine.controllers;

import org.springframework.data.repository.CrudRepository;
import searchengine.model.Lemma;

public interface LemmaRepository extends CrudRepository<Lemma, Integer> {
}
