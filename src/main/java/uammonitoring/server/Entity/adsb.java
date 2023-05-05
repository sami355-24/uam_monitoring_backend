package uammonitoring.server.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class adsb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uamIdentification;
    private String uamCurrentDate;
    private String uamCurrentTime;
    private String uamCurrentTimeReference;

    private String uamCurrentAltitude;
    private String uamCurrentLongitude;
    private String uamCurrentLatitude;

    public adsb() {
    }
}
