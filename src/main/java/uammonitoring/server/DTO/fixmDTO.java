package uammonitoring.server.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import uammonitoring.server.DTO.Common.FlightIdentifier;
import uammonitoring.server.DTO.PartOfFixmDTO.*;

import java.util.List;

@Data
@Getter @Setter
@Builder
public class fixmDTO {

    private FlightIdentifier flightIdentifier;
    private Departure departure;
    private Arrival arrival;
    private List<DTORoute> route;

    public fixmDTO() {
    }

    public fixmDTO(FlightIdentifier flightIdentifier, Departure departure, Arrival arrival, List<DTORoute> route) {
        this.flightIdentifier = flightIdentifier;
        this.departure = departure;
        this.arrival = arrival;
        this.route = route;
    }
}
