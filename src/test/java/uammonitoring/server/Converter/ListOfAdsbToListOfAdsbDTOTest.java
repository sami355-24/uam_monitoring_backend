package uammonitoring.server.Converter;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Entity.adsb;
import uammonitoring.server.Repository.adsbRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ListOfAdsbToListOfAdsbDTOTest {

    @Autowired
    ConversionService conversionService;

    @Autowired
    adsbRepository repository;
    @Test
    public void adsbConversionTest() throws Exception{
        //given
        List<adsb> adsbs = repository.findAll();

        //when
        List<adsbDTO> convert = conversionService.convert(adsbs, List.class);

        //then
        assertThat(convert).isNotNull();
        for (adsbDTO adsbDTO : convert) {
            log.info("adsbDTO.toString: {}", adsbDTO.toString());
        }
    }

}