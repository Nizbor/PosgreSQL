package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.Diploma;
import sillysociety.org.service.DiplomaService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/diploma/")
public class DiplomaController {
    @Autowired
    private DiplomaService diplomaService;

    @PostMapping(path = "add")
    public Diploma add(@RequestBody Diploma diploma) {
        return diplomaService.addDiploma(diploma);
    }

    @GetMapping(path = "get")
    public List<Diploma> get() {
        return diplomaService.getAllDiplomas();
    }

    @PutMapping(path = "update")
    public Diploma update(@RequestBody Diploma diploma) {
        return diplomaService.updateDiploma(diploma);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody Diploma diploma) {
        diplomaService.deleteDiploma(diploma);
    }
}
