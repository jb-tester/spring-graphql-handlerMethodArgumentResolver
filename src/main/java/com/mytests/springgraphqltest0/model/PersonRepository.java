package com.mytests.springgraphqltest0.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByFirstnameAndLastname(String firstname, String lastname);
}
