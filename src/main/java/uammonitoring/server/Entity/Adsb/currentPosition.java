package uammonitoring.server.Entity.Adsb;

import jakarta.persistence.Embeddable;

@Embeddable
public class currentPosition {
    private String altitude;
    private String longitude;
    private String latitude;
}
