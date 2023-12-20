package platform.codingnomads.co.springdata.example.ddl.manytomany.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String isbn;

    @Column
    private int pages;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
}
