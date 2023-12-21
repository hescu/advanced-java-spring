package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @NonNull
    private List<Author> authors;
}
