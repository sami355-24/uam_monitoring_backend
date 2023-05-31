package uammonitoring.server.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class vertiportDTO {

    private Long id;
    private String name;
    private String latitude;
    private String longitude;
}
