package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.EmpServiceUserDto;
import com.spring.gradle.defect.dto.RoleAssignDto;
import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(EmpServiceUserDto empServiceUserDto);

    void updateUser(UserDto userDto);

    User getUserById(int id);

    String deleteUserByEmpId(int emp_id);

    List<User> getUsersByAvailability();
    void setRoles(RoleAssignDto roleAssignDto);

    User getUserByEmpId(int emp_id);

    User findByUsername(String username);

}

