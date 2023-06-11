package Hospital.demo.Controller;

import Hospital.demo.Entity.Doctor;
import Hospital.demo.service.DoctorService;
import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.http.RequestEntity.post;


@WebMvcTest(DoctorController.class)
class DoctorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DoctorService doctorService;
    Doctor doctorOne;
    Doctor doctorTwo;
    List<Doctor> doctorList =new ArrayList<>();


    @BeforeEach
    void setUp() {
        doctorOne = new Doctor(1, "Dr. John Doe", LocalDate.parse("2023-05-26"), "none", 0);
        doctorTwo = new Doctor(2, "Dr. Emma Johnson", LocalDate.parse("2022-11-15"), "Migraine", 7);
        doctorList.add(doctorOne);
        doctorList.add(doctorTwo);

    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testCreateDoctor() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        when(doctorService.createDoctor(doctorOne)).thenReturn(doctorOne);

        this.mockMvc.perform((RequestBuilder) post("/doctors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.valueOf(mapper.writeValueAsString(doctorOne))))
                .andDo(print())
                .andExpect(status().isOk());
    }





    @Test
    void getDoctorDetails() {
    }

    @Test
    void getAllDoctorsWithPatients() {
    }

    @Test
    void testGetAllDoctorsWithPatients() {
    }



    @Test
    void getAllPatientsDetails() {
    }

    @Test
    void getAllPatients() {
    }

    @Test
    void getDoctorsByName() {

    }
}