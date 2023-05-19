package uammonitoring.server.DTO.PartOfAdsbDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class currentPosition {
    private double altitude;
    private double longitude;
    private double latitude;
}
