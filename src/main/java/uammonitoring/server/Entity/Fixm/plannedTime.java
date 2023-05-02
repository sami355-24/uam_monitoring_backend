package uammonitoring.server.Entity.Fixm;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class plannedTime {
    private String data;
    private String time;
    private String timeReference;
}
