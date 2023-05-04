package uammonitoring.server.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uammonitoring.server.DTO.fixmDTO;
import uammonitoring.server.Entity.fixm;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Slf4j
class fixmServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private fixmService service;

    @Test
    public void saveAndFindFixmTest() throws Exception{
        //given
        String body = "{ \"flightIdentifier\": { \"uamIdentification\": \"UAL123\" }, \"departure\": { \"vertiport\": { \"longitude\": \"126.9525465\", \"latitude\": \"37.5453577\" }, \"plannedDepartureTime\": { \"date\": \"2023-05-15\", \"time\": \"14:00:00\", \"timeReference\": \"UTC\" } }, \"arrival\": { \"vertiport\": { \"longitude\": \"126.9525465\", \"latitude\": \"37.5453577\" }, \"plannedArrivalTime\": { \"date\": \"2023-05-15\", \"time\": \"14:30:00\", \"timeReference\": \"UTC\" } }, \"route\": [ { \"longitude\": 128.6071850769231, \"latitude\": 35.883417615384616 }, { \"longitude\": 128.60773215384617, \"latitude\": 35.87885223076923 } ] }";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveFixm")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body);

        //when
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        //then
        fixmDTO result = service.findFixm("UAL123");
        log.info("result.toString : {}", result.toString());
    }

}