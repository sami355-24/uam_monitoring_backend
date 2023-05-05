package uammonitoring.server.Entity;

import jakarta.persistence.*;

import lombok.*;


import java.util.List;

@Entity
@Getter @Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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

}
