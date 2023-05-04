package uammonitoring.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uammonitoring.server.Entity.fixm;

import java.util.List;

@Repository
public interface fixmRepository extends JpaRepository<fixm, Long> {
    fixm findByUamIdentification(String uamIdentification);
}
