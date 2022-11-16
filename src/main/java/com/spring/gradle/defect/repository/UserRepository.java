package com.spring.gradle.defect.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.gradle.defect.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User,Integer>{
    @Query(value = "select * from user where availability>0",nativeQuery = true)
    public List<User>getByAvailability();

    @Query(value = "select * from user where emp_id=?",nativeQuery = true)
    public User getUserByEmpId(int emp_id);




	
}
