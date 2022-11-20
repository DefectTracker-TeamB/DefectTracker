package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.EmpServiceUserDto;
import com.spring.gradle.defect.dto.RoleAssignDto;
import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.entity.Roles;
import com.spring.gradle.defect.entity.User;
import com.spring.gradle.defect.repository.RoleRepo;
import com.spring.gradle.defect.repository.UserRepository;
import com.spring.gradle.defect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void saveUser(EmpServiceUserDto empServiceUserDto) {
        User user = new User();
        user.setEmp_id(empServiceUserDto.getEmp_id());
        user.setDesignation(empServiceUserDto.getDesignation());
        user.setAvailability(100);
        user.setName(empServiceUserDto.getName());
        user.setUsername(empServiceUserDto.getUserName());
        user.setPassword(empServiceUserDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    //UPDATE
    @Override
    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        user.setEmp_id(userDto.getEmp_id());
        user.setDesignation(userDto.getDesignation());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        List<Integer>role_id=userDto.getRole_id();
        if(role_id!=null){
            Set<Roles>roles=new HashSet<>();
            for(Integer i:role_id){
                roles.add(roleRepo.getById(i));
            }
            user.setRoles(roles);
        }

        userRepository.save(user);
    }

    //DELETE
    @Override
    public String deleteUserByEmpId(int emp_id) {
        User user = userRepository.getUserByEmpId(emp_id);
        if (user != null) {
            userRepository.deleteById(user.getId());
            return "user removed";
        } else {
            return "user doesn't exists";
        }
    }

    @Override
    public List<User> getUsersByAvailability() {
        return userRepository.getByAvailability();
    }

    @Override
    public void setRoles(RoleAssignDto roleAssignDto) {
        User user=userRepository.findById(roleAssignDto.getUser_id()).get();
        List<Integer>role_id=roleAssignDto.getRole_id();
        if(role_id!=null){
            Set<Roles>roles=new HashSet<>();
            for (Integer i:role_id){
                roles.add(roleRepo.getById(i));
            }
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

    @Override
    public User getUserByEmpId(int emp_id) {
        return userRepository.getUserByEmpId(emp_id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
