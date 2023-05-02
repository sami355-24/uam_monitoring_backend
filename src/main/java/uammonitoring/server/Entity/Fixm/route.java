package uammonitoring.server.Entity.Fixm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uammonitoring.server.Entity.fixm;

@Entity
@Getter @Setter
@NoArgsConstructor
public class route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Long id;
    private String longitude;
    private String latitude;

    @ManyToOne
    @JoinColumn(name = "fixm_id")
    private fixm fixm;
}
