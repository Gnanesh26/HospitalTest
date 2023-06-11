package Hospital.demo.service;

import Hospital.demo.Entity.Doctor;
import Hospital.demo.Repository.DoctorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DoctorServiceTest {
    @Mock
    private DoctorRepository doctorRepository;
    private DoctorService doctorService;
    private AutoCloseable autoCloseable;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        doctorService = new DoctorService(doctorRepository);
        doctor = new Doctor(1, "Dr. John Doe", LocalDate.parse("2023-05-26"), "none", 0);
    }


    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testGetAllDoctors() {
        mock(Doctor.class);
        mock(DoctorRepository.class);
        when(doctorRepository.findAll()).thenReturn(new ArrayList<Doctor>(
                Collections.singleton(doctor)
        ));
        assertThat(doctorService.getAllDoctors()).containsExactly(doctor);
    }

    @Test
    void testCreateDoctor() {
        mock(Doctor.class);
        mock(DoctorRepository.class);
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        Doctor savedDoctor = doctorService.createDoctor(doctor);
        assertThat(savedDoctor).isEqualTo(doctor);
    }

    @Test
    void testGetDoctorsByName() {
        mock(Doctor.class);
        mock(DoctorRepository.class);

        when(doctorRepository.findByNameIgnoreCase("Dr. John Doe")).thenReturn(Collections.singletonList(doctor));

        assertThat(doctorService.getDoctorsByName("Dr. John Doe")).isNotEmpty().contains(doctor);
    }

//    @Test
//    void testGetDoctorById() {
//        mock(Doctor.class);
//        mock(DoctorRepository.class);
//
//        int doctorId = 1;
//        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
//
//        String doctorAsString = doctorService.getDoctorById(doctorId);
//
//        assertThat(doctorAsString).isNotNull().isEqualTo(doctor.toString());
//    }
}


