package uammonitoring.server.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.DTO.adsbDTO;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
public class adsbServiceTest {

    @Autowired
    private adsbService service;

    @Test
    public void findAllAdsbTest() throws Exception{
        //given

        //when
        List<adsbDTO> allAdsb = service.findAllAdsb();

        //then
        assertThat(allAdsb).isNotNull();
        for (adsbDTO adsbDTO : allAdsb) {
            log.info("findAllAdsbTest : {}", adsbDTO.toString());
        }
    }

    @Test
    public void completeFlightTest() throws Exception{
        //given

        //when
        service.completeFlight("BKDG001");

        //then
        List<adsbDTO> allAdsb = service.findAllAdsb();
        assertThat(allAdsb).isEmpty();
    }

    @Test
    public void existsByUamIdentificationTest() throws Exception{
        //given
        String uamIdentification = "UAL123";

        //when
        Map<String, Boolean> result = service.existsByUamIdentification(uamIdentification);

        //then
        assertThat(result.get("status")).isTrue();
    }
}
