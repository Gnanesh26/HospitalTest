package Hospital.demo.Repository;

import Hospital.demo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findByName(String name);
}
