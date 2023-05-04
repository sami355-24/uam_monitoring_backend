package uammonitoring.server.DTO.partOfFixmDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Departure {
    private Vertiport vertiport;
    private PlannedTime plannedDepartureTime;

    public Departure() {
    }
}

