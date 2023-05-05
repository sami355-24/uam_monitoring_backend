package uammonitoring.server.DTO.PartOfFixmDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arrival {
    private Vertiport vertiport;
    private PlannedTime plannedArrivalTime;
}

