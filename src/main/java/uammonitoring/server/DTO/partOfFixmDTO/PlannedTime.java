package uammonitoring.server.DTO.partOfFixmDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlannedTime {
    private String date;
    private String time;
    private String timeReference;
}
