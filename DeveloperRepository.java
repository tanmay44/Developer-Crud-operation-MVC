package com.example.demo1.repository;

import com.example.demo1.entity.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
    Developer findOne(Long id);
}
