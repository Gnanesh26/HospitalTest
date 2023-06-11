package Hospital.demo.service;

import Hospital.demo.Entity.Doctor;
import Hospital.demo.Entity.UserInfo;
import Hospital.demo.Repository.DoctorRepository;
import Hospital.demo.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService {


    @Autowired
    private DoctorRepository doctorRepository;
//    @Autowired
//    DoctorRepository doctorRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }



    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }



    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }



    public String addUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "user added sucessfully";

    }

    public List<Doctor> getDoctorsByName(String name) {
        List<Doctor> doctors = doctorRepository.findByNameIgnoreCase(name);
        return doctors;
    }

    public String getDoctorById(int id) {
//                return (String) doctorRepository.findById(id).orElse(null);
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        String doctorAsString = null;
        if (doctor != null) {
            doctorAsString = doctor.toString(); // assuming the Doctor class overrides the toString() method
        }
        return doctorAsString;
    }
}

