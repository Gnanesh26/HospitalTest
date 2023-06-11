package Hospital.demo.Repository;

import Hospital.demo.Entity.Doctor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByNameIgnoreCase(String name);

    List<Doctor> findByName(String s);
//    Optional<Doctor> findById(Integer id);

    Optional<Object> findById(Doctor id);

    List<Doctor> findByDoctorName(String s);


    Optional<Doctor> findById(Integer doctorId);



}
