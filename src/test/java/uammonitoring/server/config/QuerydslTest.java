package uammonitoring.server.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import uammonitoring.server.Entity.member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static uammonitoring.server.Entity.Qmember.*;

@SpringBootTest
@Transactional
public class QuerydslTest {

    @Autowired
    JPAQueryFactory queryFactory;

    @Test
    public void Querydsl() throws Exception{
        //given
        String name = "test";

        //when

        List<member> members = queryFactory
                .selectFrom(member)
                .where(member.name.eq(name))
                .fetch();

        //then
        assertThat(members.size()).isEqualTo(1);
        assertThat(members.get(0).getName()).isEqualTo(name);
    }
}
