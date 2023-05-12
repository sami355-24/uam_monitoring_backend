package uammonitoring.server.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.Entity.adsb;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
@Slf4j
class adsbRepositoryTest {

    @Autowired
    adsbRepository repository;

    @Test
    public void findAllAdsbTest() throws Exception{
        //given

        //when
        List<adsb> all = repository.findAll();

        //then
        Assertions.assertThat(all).isNotNull();
        for (adsb adsb : all) {
            log.info("findAllAdsbTest : {}", adsb.toString());
        }
    }

    @Test
    public void deleteByuamIdentificationTest() throws Exception{
        //given
        String uamIdentification = "UAL123";

        //when
        repository.deleteByuamIdentification(uamIdentification);

        //then
        List<adsb> all = repository.findAll();
        Assertions.assertThat(all).isEmpty();
    }
}