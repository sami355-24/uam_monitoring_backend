package uammonitoring.server.Entity.Adsb;

import jakarta.persistence.Embeddable;


@Embeddable
public class currentTime {
    private String date;
    private String time;
    private String timeReference;
}
