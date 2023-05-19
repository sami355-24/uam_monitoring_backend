package uammonitoring.server.Controller;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import uammonitoring.server.DTO.adsbDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class adsbControllerTest {

    @Autowired
    private adsbController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void completeFlightTest() throws Exception{
       //given
        String Url = "/completeFlight?uamIdentification=UAL123";

        //when
        mockMvc.perform(MockMvcRequestBuilders.get(Url))
                .andExpect(status().isOk())
                .andDo(print());

        //then
        List<adsbDTO> adsb = controller.findAdsb();
        assertThat(adsb).isEmpty();
    }

    @Test
    public void adsbStatus() throws Exception{
        //given
        String Url = "/status?uamIdentification=UAL123";

        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(Url))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        //then
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.printf("contentAsString : %s\n", contentAsString);
    }
}