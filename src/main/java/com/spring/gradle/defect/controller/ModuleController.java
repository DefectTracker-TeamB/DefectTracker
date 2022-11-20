package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.service.ModuleService;
import com.spring.gradle.defect.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import antlr.collections.List;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Create
    @PostMapping(Constants.CREATEMODULE) // ("/createMod")
    public ResponseEntity<Object> createModule(@RequestBody ModuleDto moduleDto) {
        moduleService.createModule(moduleDto);
        return ResponseEntity.ok("Module created successfully");

    }

    // Get all
    @GetMapping(Constants.GETALLMODULE) // ("Modules")
    public ResponseEntity<Object> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModule());
    }

    //
    // Get By Id
    @GetMapping(Constants.GETBYMODULEID) // ("/module/{id}")
    public ResponseEntity<Object> getModuleById(@PathVariable int id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }

    // Update
    @PutMapping(Constants.UPDATEMODULE) // ("/update/{id}")
    public ResponseEntity<Object> updateModule(@RequestBody ModuleDto moduleDto) {
        moduleService.updateModule(moduleDto);
        return ResponseEntity.ok("Module Edited");
    }

    // Delete
    @DeleteMapping(Constants.DELETEMODULE) // ("/delete/{id}")
    public ResponseEntity<Object> deleteModule(@PathVariable int id) {
        moduleService.deleteModule(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
