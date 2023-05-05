package uammonitoring.server.DTO;

import lombok.*;
import uammonitoring.server.DTO.Common.FlightIdentifier;
import uammonitoring.server.DTO.PartOfAdsbDTO.currentPosition;
import uammonitoring.server.DTO.PartOfAdsbDTO.currentTime;

@Data
@Getter @Setter
@Builder
@AllArgsConstructor
public class adsbDTO {

    private FlightIdentifier flightIdentifier;
    private currentTime currentTime;
    private currentPosition currentPosition;

    public adsbDTO() {
    }
}
