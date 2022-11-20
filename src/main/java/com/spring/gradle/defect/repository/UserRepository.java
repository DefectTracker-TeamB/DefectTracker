package com.spring.gradle.defect.repository;


import com.spring.gradle.defect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where availability>0", nativeQuery = true)
    List<User> getByAvailability();

    @Query(value = "select * from user where emp_id=?", nativeQuery = true)
    User getUserByEmpId(int emp_id);

    User findByUsername(String userName);


}
