package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService service;

    @GetMapping(path = "/")
    public String home() {
        return "index";
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewPatient (@RequestParam String hospName
            , @RequestParam String hospCity
            , @RequestParam Integer roomNo
            , @RequestParam String firstName
            , @RequestParam String lastName
            , @RequestParam String disease
            , @RequestParam Date dateOfPlacing) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Patient n = new Patient();
        n.setHospName(hospName);
        n.setHospCity(hospCity);
        n.setRoomNo(roomNo);
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setDisease(disease);
        n.setDateOfPlacing(dateOfPlacing);
        patientRepository.save(n);
        return "Saved";
    }

    @RequestMapping(path = {"/patients","/patients/search"})
    public String listPatients(Model model, String keyword) {
        if (keyword == null || keyword.length() == 0) {
            List<Patient> list = service.getAllPatients();
            model.addAttribute("list", list);
        } else {
            List<Patient> list = service.getByKeyword(keyword);
            model.addAttribute("list", list);
        }
        return "list-patients";
    }
}