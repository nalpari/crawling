package net.nalpari.crawling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nalpari.crawling.model.Person;
import net.nalpari.crawling.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

//    @Autowired
//    private PersonRepository repo;

    public Person findByName(String name) {
        return repository.findByName(name);
    }

    public Person save(Person person) {
//        Person param = Person
//                .builder()
//                .name(person.getName())
//                .job(person.getJob())
//                .build();
        log.debug("### Person: {}", person);
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }
}
