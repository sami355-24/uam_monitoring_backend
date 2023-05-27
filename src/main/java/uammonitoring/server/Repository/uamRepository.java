package uammonitoring.server.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uammonitoring.server.Entity.uam;

@Repository
public interface uamRepository extends JpaRepository<uam, Long> {
}
