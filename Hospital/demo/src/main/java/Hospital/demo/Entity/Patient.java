package Hospital.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "name")
    private String name;


    @Column(name = "disease")
    private String disease;

    @Column(name = "severity")
    private Integer severity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dean_id")
    private Dean dean;



    @ManyToOne
    @JoinColumn(name = "assigned_doctor_id")
    @JsonIgnore
    private Doctor assignedDoctor;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "status")
    private String status;
//    @Column(name = "dean_id", insertable = false, updatable = false)
//    private int deanId;



//    public Patient(Integer patientId, String name, String disease, Integer severity, Dean dean, Doctor assignedDoctor, LocalDate joinDate, String status, int deanId) {
//        this.patientId = patientId;
//        this.name = name;
//        this.disease = disease;
//        this.severity = severity;
//        this.dean = dean;
//        this.assignedDoctor = assignedDoctor;
//        this.joinDate = joinDate;
//        this.status = status;
////        this.deanId = deanId;
//    }
    public Patient(Integer patientId, String name, String disease, Integer severity, Doctor assignedDoctor, LocalDate joinDate, String status) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.severity = severity;
        this.assignedDoctor = assignedDoctor;
        this.joinDate = joinDate;
        this.status = status;
    }

    public Patient() {
    }

    public Patient(int i, String emmaJohnson, String migrane, int i1, int i2, LocalDate parse, String discharge, int i3) {
    }

//    public Patient(int patientId, String emmaJohnson, String migrane, int severity, int i, LocalDate parse, String discharge,int deanId) {
//    }

//    public Patient(int patientId, String emmaJohnson, String migrane, int severity, int i, int i1, String discharge) {
//    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Integer id) {
    }

    public void setDoctor(Doctor doctor) {
    }
}
