package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "baumbarts")
@NoArgsConstructor
@Getter
@Setter
public class Baumbart {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int height;
}
