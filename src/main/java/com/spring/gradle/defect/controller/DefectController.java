package com.spring.gradle.defect.controller;

<<<<<<< Updated upstream
=======
import java.util.List;

>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle.defect.entity.Defect;
import com.spring.gradle.defect.service.DefectService;
import com.spring.gradle.defect.util.Constants;

@RestController
public class DefectController {
@Autowired
DefectService defectService;

@PostMapping(Constants.DEFECT)
public ResponseEntity<Object>CreateIncomingSample(@RequestBody Defect defect){
	defectService.saveDefect(defect);
	return ResponseEntity.ok("Defect Saved Successfully!");
	
}
@GetMapping(Constants.GET_DEFECT)
public ResponseEntity<Object> getDefectById(@PathVariable Long id) {

	return ResponseEntity.ok(defectService.getDefectById(id));
}

@PutMapping(Constants.PUT_DEFECT)
public Defect updateDefect(@RequestBody Defect defect) {
	 System.out.println("Successfully update!");
	 defectService.updateDefect(defect);
	 return defect;
	}

@DeleteMapping(Constants.DELE_DEFECT)
public ResponseEntity<Object>deleteDefect(@PathVariable Long id){
	defectService.deleteDefect(id);
	return ResponseEntity.ok("Delete Successfully!");
}
<<<<<<< Updated upstream
=======
@GetMapping(Constants.GET_ALLDEFECT)
public List<Defect> getAllDefect() {
    return defectService.getAllDefect();
}
>>>>>>> Stashed changes

}
