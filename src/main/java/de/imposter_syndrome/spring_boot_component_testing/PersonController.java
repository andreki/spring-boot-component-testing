package de.imposter_syndrome.spring_boot_component_testing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PersonController {
    private final PersonRepository repository;

    @PutMapping
    public Person addPerson(@RequestBody String name) {
        Person person = new Person.PersonBuilder().name(name).build();
        person = repository.save(person);
        log.info("added Person: {}", person);
        return person;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        List<Person> persons = repository.findAll();
        log.info("found Persons: {}", persons);
        return persons;
    }
}
