package uammonitoring.server.Controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uammonitoring.server.Entity.vertiport;
import uammonitoring.server.Repository.vertiportRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class vertiportControllerTest {

    @Autowired
    vertiportController controller;

    @Autowired
    vertiportRepository repository;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void init () throws Exception{
        List<String> latitudes = List.of("1", "2", "3");
        List<String> longitudes = List.of("1", "2", "3");

        //when
        for (int i = 0; i < 3; i++) {
            repository.save(new vertiport(latitudes.get(i), longitudes.get(i)));
        }
    }

    @Test
    public void findAllTest() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.get("/vertiports"))
                    .andExpect(status().isOk())
                .andDo(print());

    }

}