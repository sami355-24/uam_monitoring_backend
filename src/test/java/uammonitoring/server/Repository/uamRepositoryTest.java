package uammonitoring.server.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.Entity.uam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class uamRepositoryTest {

    @Autowired
    private uamRepository repository;

    @Test
    public void insertTest() throws Exception{
        //given
        List<uam> data = new ArrayList<>();
        uam dummy = new uam();
        dummy.setName("BKDG001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("DGBK001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("JGBK001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("NGDS001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("SSDG001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("DSBK001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("NGBK001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("DSDS001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("SSNG001");
        data.add(dummy);

        dummy = new uam();
        dummy.setName("DSBK002");
        data.add(dummy);

        //when
        repository.saveAll(data);

        //then
        List<uam> all = repository.findAll();
        for (uam uam : all) {
            System.out.println(uam.getName());
        }
    }

}