package uammonitoring.server.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Entity.adsb;

import java.util.List;

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
}
