package searchengine.controllers;

import org.springframework.data.repository.CrudRepository;
import searchengine.model.Page;

public interface PageRepository extends CrudRepository<Page, Integer> {
}
