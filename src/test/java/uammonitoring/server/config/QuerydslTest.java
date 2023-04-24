package uammonitoring.server.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import uammonitoring.server.Entity.member;
import uammonitoring.server.Repository.memberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static uammonitoring.server.Entity.Qmember.*;

@SpringBootTest
@Transactional
public class QuerydslTest {

    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    memberRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void Querydsl() throws Exception{
        //given
        String name = "test";
        uammonitoring.server.Entity.member createMember = uammonitoring.server.Entity.member.builder()
                .name(name)
                .password("test")
                .build();

        //when
        repository.save(createMember);

        em.flush();
        em.clear();

        List<member> members = queryFactory
                .selectFrom(member)
                .where(member.name.eq(name))
                .fetch();

        //then
        assertThat(members.size()).isEqualTo(1);
        assertThat(members.get(0).getName()).isEqualTo(name);
    }
}
