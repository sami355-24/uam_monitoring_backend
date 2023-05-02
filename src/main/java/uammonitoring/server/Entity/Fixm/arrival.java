package uammonitoring.server.Entity.Fixm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "arrival_id")
    private Long id;

    @Embedded
    private vertiport vertiport;

    @Embedded
    private plannedTime plannedArrivalTime;
}
