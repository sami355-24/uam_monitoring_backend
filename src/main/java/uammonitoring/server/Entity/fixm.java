package uammonitoring.server.Entity;

import jakarta.persistence.*;
import uammonitoring.server.Entity.Common.flightIdentifier;
import uammonitoring.server.Entity.Fixm.arrival;
import uammonitoring.server.Entity.Fixm.departure;
import uammonitoring.server.Entity.Fixm.route;

import java.util.List;

@Entity
public class fixm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fixm_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flightIdentifier_id")
    private flightIdentifier flightIdentifier;

    @OneToOne
    @JoinColumn(name = "departure_id")
    private departure departure;

    @OneToOne
    @JoinColumn(name = "arrival_id")
    private arrival arrival;

    @OneToMany(mappedBy = "fixm")
    private List<route> route;
}
