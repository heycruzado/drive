package com.alex.drive.repository;

import com.alex.drive.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Person, Long> {
}