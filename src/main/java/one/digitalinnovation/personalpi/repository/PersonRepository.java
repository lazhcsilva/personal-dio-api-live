package one.digitalinnovation.personalpi.repository;

import one.digitalinnovation.personalpi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {



}
