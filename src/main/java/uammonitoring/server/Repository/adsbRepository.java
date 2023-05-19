package uammonitoring.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uammonitoring.server.Entity.adsb;

@Repository
public interface adsbRepository extends JpaRepository<adsb, Long> {

    void deleteByuamIdentification(String uamIdentification);

   boolean existsByUamIdentification(String uamIdentification);
}
