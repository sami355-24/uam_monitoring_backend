package uammonitoring.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uammonitoring.server.Entity.vertiport;

@Repository
public interface vertiportRepository extends JpaRepository<vertiport, Long> {
}
