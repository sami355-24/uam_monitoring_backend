package uammonitoring.server.config;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import uammonitoring.server.Entity.member;
import uammonitoring.server.Repository.memberRepository;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class JPATest {

    @Autowired
    public memberRepository repository;


    @Test
    public void JPA() throws Exception{
        //given
        member createMember = member.builder()
                .name("test")
                .password("test")
                .build();


        //when
        repository.save(createMember);
        Long id = createMember.getId();

        member findMember = repository.findById(id).get();

        //then
        assertThat(findMember.getId()).isEqualTo(createMember.getId());
    }
}
