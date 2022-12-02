package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Defect;
import java.util.List;

public interface DefectService {

    void saveDefect(DefectDto defectDto);

    List<Defect> getAllDefect();

    Defect getDefectById(int id);

    void deleteDefect(int id);

    void updateDefect(DefectDto defectDto);

    void setStatus(StatusDto statusDto);

}
