package uammonitoring.server.domain.Adsb;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class flightData {
    private flightIdentifier flightIdentifier;
    private currentTime currentTime;
    private uammonitoring.server.Entity.currentPosition currentPosition;
}
