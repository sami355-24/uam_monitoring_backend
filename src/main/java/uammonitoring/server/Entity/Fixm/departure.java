package uammonitoring.server.Entity.Fixm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class departure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departure_id")
    private Long id;

    @Embedded
    private vertiport vertiport;

    @Embedded
    private plannedTime plannedDepartureTime;
}
