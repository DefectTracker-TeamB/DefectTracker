package com.spring.gradle.defect.service;

<<<<<<< Updated upstream
=======
import java.util.List;

>>>>>>> Stashed changes
import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.entity.Defect;

public interface DefectService {
	
	void saveDefect(Defect defect);
	Defect updateDefect(Defect defect);
	void deleteDefect(Long id);
	DefectDto getDefectById(Long id);
<<<<<<< Updated upstream
=======
	List<Defect> getAllDefect();
>>>>>>> Stashed changes
	

}
