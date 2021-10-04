package com.psychology.studywork.repository;

import com.psychology.studywork.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public class PersonRepository extends CrudRepository<Person, String> {
    public Person findByEmailIgnoreCase(@Param("email") String email);
}
