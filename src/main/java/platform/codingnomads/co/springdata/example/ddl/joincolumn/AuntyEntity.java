package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "aunty_entities")
@NoArgsConstructor
@Getter
@Setter
public class AuntyEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "references_name", referencedColumnName = "name"),
            @JoinColumn(name = "references_height", referencedColumnName = "height")
    })
    private Baumbart baumbart;
}
