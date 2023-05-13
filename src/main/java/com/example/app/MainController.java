package com.example.app;

import com.example.app.entities.Appliance;
import com.example.app.entities.Appointment;
import com.example.app.entities.Patient;
import com.example.app.repositories.ApplianceRepository;
import com.example.app.repositories.AppointmentRepository;
import com.example.app.repositories.PatientRepository;
import com.example.app.services.ApplianceService;
import com.example.app.services.AppointmentService;
import com.example.app.services.PatientService;
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
    private PatientService patientService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ApplianceRepository applianceRepository;

    @Autowired
    private ApplianceService applianceService;

    @GetMapping(path = "/")
    public String home() {
        return "index";
    }

    @RequestMapping("/patients/add")
    public String addPatients() {
        return "add-patients";
    }

    @RequestMapping("/appointments/add")
    public String addAppointments() {
        return "add-appointments";
    }

    @PostMapping("/patients/save")
    public void addPatient(@RequestParam("hospName") String hospName,
                           @RequestParam("hospCity") String hospCity,
                           @RequestParam("roomNo") int roomNo,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("disease") String disease,
                           @RequestParam("dateOfPlacing") Date dateOfPlacing
                           ) {
        patientService.addPatient(hospName, hospCity, roomNo, firstName, lastName, disease, dateOfPlacing);
    }


//    @PostMapping(path="/patients/save") // Map ONLY POST Requests
//    @ResponseBody
//    public String addNewPatient (@RequestParam String hospName
//            , @RequestParam String hospCity
//            , @RequestParam Integer roomNo
//            , @RequestParam String firstName
//            , @RequestParam String lastName
//            , @RequestParam String disease
//            , @RequestParam Date dateOfPlacing) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        Patient n = new Patient();
//        n.setHospName(hospName);
//        n.setHospCity(hospCity);
//        n.setRoomNo(roomNo);
//        n.setFirstName(firstName);
//        n.setLastName(lastName);
//        n.setDisease(disease);
//        n.setDateOfPlacing(dateOfPlacing);
//        patientRepository.save(n);
//        return "Saved";
//    }

    @RequestMapping(path = {"/patients","/patients/search"})
    public String listPatients(Model model, String keyword) {
        if (keyword == null || keyword.length() == 0) {
            List<Patient> list = patientService.getAllPatients();
            model.addAttribute("list", list);
        } else {
            List<Patient> list = patientService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }
        return "list-patients";
    }

    @RequestMapping(path = {"/appointments","/appointments/search"})
    public String listAppointments(Model model, String keyword) {
        if (keyword == null || keyword.length() == 0) {
            List<Appointment> list = appointmentService.getAllAppointments();
            model.addAttribute("list", list);
        } else {
            List<Appointment> list = appointmentService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }
        return "list-appointments";
    }

    @RequestMapping(path = {"/appliance","/appliance/search"})
    public String listAppliance(Model model, String keyword) {
        if (keyword == null || keyword.length() == 0) {
            List<Appliance> list = applianceService.getAllAppliance();
            model.addAttribute("list", list);
        } else {
            List<Appliance> list = applianceService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }
        return "list-appliance";
    }
}