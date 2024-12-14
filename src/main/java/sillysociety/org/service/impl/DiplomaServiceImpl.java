package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.Diploma;
import sillysociety.org.repository.DiplomaRepository;
import sillysociety.org.service.DiplomaService;

import java.util.List;

@Service
public class DiplomaServiceImpl implements DiplomaService {
    @Autowired
    private DiplomaRepository diplomaRepository;

    @Override
    public Diploma addDiploma(Diploma diploma) {
        return diplomaRepository.save(diploma);
    }

    @Override
    public void deleteDiploma(Diploma diploma) {
        diplomaRepository.delete(diploma);
    }

    @Override
    public Diploma getDiplomaById(Integer id) {
        return diplomaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Diploma> getAllDiplomas() {
        return (List<Diploma>) diplomaRepository.findAll();
    }

    @Override
    public Diploma updateDiploma(Diploma diploma) {
        return diplomaRepository.save(diploma);
    }
}
