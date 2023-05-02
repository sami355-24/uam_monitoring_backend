package uammonitoring.server.Entity.Common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class flightIdentifier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flightIdentifier_id")
    private Long id;
    private String uamIdentification;
}
