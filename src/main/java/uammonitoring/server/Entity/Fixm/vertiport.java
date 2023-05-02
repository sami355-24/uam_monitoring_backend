package uammonitoring.server.Entity.Fixm;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class vertiport {
    private String longitude;
    private String latitude;
}
