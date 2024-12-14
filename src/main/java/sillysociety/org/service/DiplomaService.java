package sillysociety.org.service;

import sillysociety.org.models.Diploma;

import java.util.List;

public interface DiplomaService{
    Diploma addDiploma(Diploma diploma);
    void deleteDiploma(Diploma diploma);
    Diploma getDiplomaById(Integer id);
    List<Diploma> getAllDiplomas();
    Diploma updateDiploma(Diploma diploma);
}
