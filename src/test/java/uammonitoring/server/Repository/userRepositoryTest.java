package uammonitoring.server.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.Entity.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class userRepositoryTest {

    @Autowired
    UserRepository repository;
    @Autowired
    JPAQueryFactory queryFactory;
    @Autowired
    EntityManager em;

    @Test
    public void JPATest() throws Exception{
        //given
        User createUser = User.builder()
                .name("test")
                .password("test")
                .build();

        //when
        repository.save(createUser);
        Long id = createUser.getId();
        User findUser = repository.findById(id).get();

        //then
        assertThat(findUser.getId()).isEqualTo(createUser.getId());
    }


//    public void QuerydslTest() throws Exception{
//        //given
//        String name = "test";
//        User createUser = User.builder()
//                .name(name)
//                .password("test")
//                .build();
//
//        //when
//        repository.save(createUser);
//        em.flush();
//        em.clear();
//
//        List<User> Users = queryFactory
//                .selectFrom(Qmember.member)
//                .where(Qmember.member.name.eq(name))
//                .fetch();
//
//        //then
//        assertThat(Users.size()).isEqualTo(1);
//        assertThat(Users.get(0).getName()).isEqualTo(name);
//    }
}