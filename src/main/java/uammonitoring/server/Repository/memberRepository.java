package uammonitoring.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uammonitoring.server.Entity.member;

@Repository
public interface memberRepository extends JpaRepository<member, Long> {

}
