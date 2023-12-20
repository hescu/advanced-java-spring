package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "stable")
@NoArgsConstructor
@Getter
@Setter
public class Stable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Driver driver;

}
