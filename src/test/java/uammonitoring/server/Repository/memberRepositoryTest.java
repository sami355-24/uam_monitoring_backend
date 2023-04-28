package uammonitoring.server.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.Entity.Qmember;
import uammonitoring.server.Entity.member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class memberRepositoryTest {

    @Autowired
    memberRepository repository;
    @Autowired
    JPAQueryFactory queryFactory;
    @Autowired
    EntityManager em;

    @Test
    public void JPATest() throws Exception{
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


    @Test
    public void QuerydslTest() throws Exception{
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
                .selectFrom(Qmember.member)
                .where(Qmember.member.name.eq(name))
                .fetch();

        //then
        assertThat(members.size()).isEqualTo(1);
        assertThat(members.get(0).getName()).isEqualTo(name);
    }
}