package uammonitoring.server.Entity;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class flightData {
    private uammonitoring.server.domain.Adsb.flightIdentifier flightIdentifier;
    private uammonitoring.server.domain.Adsb.currentTime currentTime;
    private uammonitoring.server.domain.Adsb.currentPosition currentPosition;
}
