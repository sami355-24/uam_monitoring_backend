package uammonitoring.server.domain.Adsb;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class currentTime {
    private String date;
    private String time;
    private String timeReference;
}
