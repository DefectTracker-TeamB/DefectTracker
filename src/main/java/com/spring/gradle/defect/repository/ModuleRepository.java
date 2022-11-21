package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

    //@SuppressWarnings("unchecked")
    //Module save(Module module);


}
