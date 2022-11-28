package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Notification;
import com.spring.gradle.defect.service.DefectService;
import com.spring.gradle.defect.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/defect")
@RestController
public class DefectController {

    @Autowired
    DefectService defectService;


    // Create defect
    @PostMapping(Constants.CREATEDEFECT)
    public ResponseEntity<Object> createDefect(@RequestBody DefectDto defectDto,Notification notification) {
        defectService.saveDefect(defectDto,notification);
        return ResponseEntity.ok(" Defect Successfully created!");

    }


    // Get all defects
    @GetMapping(Constants.GET_ALLDEFECT)
    public ResponseEntity<Object> getDefect() {
        return ResponseEntity.ok(defectService.getAllDefect());
    }


    //Get defect
    @GetMapping(Constants.GET_DEFECT)
    public ResponseEntity<Object> getDefectById(@PathVariable int id) {
        return ResponseEntity.ok(defectService.getDefectById(id));
    }


    //update defect
    @PutMapping(Constants.PUT_DEFECT)
    public ResponseEntity<Object> updateDefect(@RequestBody DefectDto defectDto) {
        defectService.updateDefect(defectDto);
        return ResponseEntity.ok().body("Successfully edited");

    }

    //Delete defect
    @DeleteMapping(Constants.DELE_DEFECT)
    public ResponseEntity<Object> deleteDefect(@PathVariable int id) {
        defectService.deleteDefect(id);
        return ResponseEntity.ok("Delete Successfully!");
    }

    @PostMapping("/status")
    public ResponseEntity<Object> changeStatus(@RequestBody StatusDto statusDto) {
        defectService.setStatus(statusDto);
        return ResponseEntity.ok("status changed");
    }


}
