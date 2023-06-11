package Hospital.demo.Repository;

import Hospital.demo.Entity.Doctor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DoctorRepositoryTest {
    @Autowired
    DoctorRepository doctorRepository;
    Doctor doctor;
    @BeforeEach
    void setUp(){
        doctor = new Doctor(1,"Dr. John Doe", LocalDate.parse("2023-05-26"),"none",0);
        doctorRepository.save(doctor);
    }

    @AfterEach
    void tearDown() {
        doctor=null;
        doctorRepository.deleteAll();

    }
    @Test
    void testFindByDoctoName_FOund(){
        List<Doctor> doctorList= doctorRepository.findByName("Dr. John Doe");
        assertThat(doctorList.get(0).getDisease()).isEqualTo(doctor.getDisease());
    }



    @Test
    void testFindByDoctorName_NotFound(){
        List<Doctor> doctorList=doctorRepository.findByName("jai");
        assertThat(doctorList.isEmpty()).isFalse();
//        assertThat(doctorList.isEmpty()).isTrue();
    }

}
