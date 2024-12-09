package com.mytests.springgraphqltest0;

import com.mytests.springgraphqltest0.model.Person;
import com.mytests.springgraphqltest0.model.PersonRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Controller
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @QueryMapping
    public List<Person> allPersonQuery() {
        return (List<Person>) personRepository.findAll();
    }

    @Transactional
    @MutationMapping() // error, though the custom handler for Person-type arg exists
    public Person addPerson1(Person person) {
        personRepository.save(person);
        return person;
    }



    @QueryMapping // error, though the custom handler for NamesHandler-type arg exists
    public List<Person> personByNames(NamesHandler namesHandler) {
        return personRepository.findByFirstnameAndLastname(namesHandler.getName1(), namesHandler.getName2());
    }
}
