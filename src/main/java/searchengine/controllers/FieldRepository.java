package searchengine.controllers;

import org.springframework.data.repository.CrudRepository;
import searchengine.model.Field;

public interface FieldRepository extends CrudRepository<Field, Integer> {
}
