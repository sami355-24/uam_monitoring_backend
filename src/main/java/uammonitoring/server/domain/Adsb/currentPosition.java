package uammonitoring.server.domain.Adsb;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class currentPosition {
    private String altitude;
    private String longitude;
    private String latitude;
}
