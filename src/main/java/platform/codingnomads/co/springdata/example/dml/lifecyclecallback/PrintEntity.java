package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here
    @PrePersist
    private void writeId() {
        System.out.println("lalalalalalalala pre persist: " + id);
    }

    @PostPersist
    private void postWriteId() {
        System.out.println("asdsadsasadsdsa post post " + id);
    }
}
