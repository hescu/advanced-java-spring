package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;
}
