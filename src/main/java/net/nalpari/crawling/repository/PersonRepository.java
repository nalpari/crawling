package net.nalpari.crawling.repository;

import net.nalpari.crawling.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    public Person findByName(String name);
    public Person save(Person person);
    public List<Person> findAll();
}
