package uammonitoring.server.DTO.PartOfAdsbDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class currentTime {
    private String date;
    private String time;
    private String timeReference;
}
