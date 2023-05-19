package uammonitoring.server.Repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import uammonitoring.server.Entity.vertiport;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class vertiportRepositoryTest {

    @Autowired
    private vertiportRepository repository;

    @Test
    public void insertVertiportTest() throws Exception{
        //given
        List<String> latitudes = List.of("1", "2", "3");
        List<String> longitudes = List.of("1", "2", "3");

        //when
        for (int i = 0; i < 3; i++) {
            repository.save(new vertiport(latitudes.get(i), longitudes.get(i)));
        }

        //then
        List<vertiport> all = repository.findAll();
        org.assertj.core.api.Assertions.assertThat(all).isNotNull();
        for (vertiport vertiport : all) {
            System.out.println(vertiport.toString());
        }
    }

}