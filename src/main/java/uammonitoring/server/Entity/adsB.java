package uammonitoring.server.Entity;

import jakarta.persistence.*;
import uammonitoring.server.Entity.Adsb.currentPosition;
import uammonitoring.server.Entity.Adsb.currentTime;
import uammonitoring.server.Entity.Common.flightIdentifier;

@Entity
public class adsB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adsB_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flightIdentifier_id")
    private flightIdentifier flightIdentifier;

    @Embedded
    private currentTime currentTime;

    @Embedded
    private currentPosition currentPosition;
}
