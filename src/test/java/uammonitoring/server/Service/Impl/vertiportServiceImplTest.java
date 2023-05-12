package uammonitoring.server.Service.Impl;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.DTO.vertiportDTO;
import uammonitoring.server.Entity.vertiport;
import uammonitoring.server.Repository.vertiportRepository;
import uammonitoring.server.Service.vertiportService;

import java.util.List;


@SpringBootTest
@Transactional
class vertiportServiceImplTest {

    @Autowired
    vertiportService service;

    @Autowired
    vertiportRepository repository;

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
        //given

        //when
        List<vertiportDTO> all = service.findAll();

        //then
        Assertions.assertThat(all.size()).isEqualTo(3);
        for (vertiportDTO vertiportDTO : all) {
            System.out.println("vertiportDTO = " + vertiportDTO.toString());
        }
    }
}