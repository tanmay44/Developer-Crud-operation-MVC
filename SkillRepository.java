package com.example.demo1.repository;

import com.example.demo1.entity.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill,Long> {
    public List<Skill> findByLabel(String label);

    Skill findOne(Long skillId);
}
