package Hospital.demo.Controller;
import Hospital.demo.Entity.Doctor;
import Hospital.demo.Entity.Patient;
import Hospital.demo.Repository.DoctorRepository;
import Hospital.demo.service.DoctorService;
import Hospital.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
     PatientService patientService;
    DoctorService doctorService;

    DoctorRepository doctorRepository;

    public PatientController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

//    @PreAuthorize("hasAuthority('ROLE_DEAN') or hasAuthority('ROLE_DOCTOR')")
    @PreAuthorize("hasAuthority('ROLE_DOCTOR')")
    @GetMapping("/patients")
    public ResponseEntity<Patient> getPatientById(@RequestParam int id) {
        // Get the patient from the service
        Patient patient = patientService.getPatientById(id);

        if (patient != null) {
            // Return the patient with a 200 OK status
            return ResponseEntity.ok(patient);
        } else {
            // Return a 404 Not Found status if the patient is not found
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/patientsbyname")
    public ResponseEntity<List<Patient>> getPatientsByName(@RequestParam String name) {
        // Get the list of patients from the service
        List<Patient> patients = patientService.findByPatientName(name);

        if (!patients.isEmpty()) {
            // Return the list of patients with a 200 OK status
            return ResponseEntity.ok(patients);
        } else {
            // Return a 404 Not Found status if no patients are found
            return ResponseEntity.notFound().build();
        }
    }

}
