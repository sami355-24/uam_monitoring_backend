package uammonitoring.server.Entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;

@Entity
@Getter @Setter
@ToString
@Builder

public class fixm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String uamIdentification;
    private String departureLongitude;
    private String departureLatitude;
    private String departureDate;
    private String departureTime;
    private String departureTimeReference;

    private String arrivalLongitude;
    private String arrivalLatitude;
    private String arrivalDate;
    private String arrivalTime;
    private String arrivalTimeReference;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<route> routes;

    public fixm() {
    }

    public fixm(Long id, String uamIdentification, String departureLongitude, String departureLatitude, String departureDate, String departureTime, String departureTimeReference, String arrivalLongitude, String arrivalLatitude, String arrivalDate, String arrivalTime, String arrivalTimeReference, List<route> routes) {
        this.id = id;
        this.uamIdentification = uamIdentification;
        this.departureLongitude = departureLongitude;
        this.departureLatitude = departureLatitude;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureTimeReference = departureTimeReference;
        this.arrivalLongitude = arrivalLongitude;
        this.arrivalLatitude = arrivalLatitude;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.arrivalTimeReference = arrivalTimeReference;
        this.routes = routes;
    }
}
