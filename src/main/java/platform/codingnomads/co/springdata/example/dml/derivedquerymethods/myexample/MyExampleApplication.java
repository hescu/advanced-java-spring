package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MyExampleApplication implements CommandLineRunner {

    @Autowired
    BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(MyExampleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = Author.builder().firstName("Terry").lastName("Pratchett").build();
        Author author2 = Author.builder().firstName("Dan").lastName("Abnett").build();
        Author author3 = Author.builder().firstName("Guy").lastName("Haley").build();
        Author author4 = Author.builder().firstName("Chris").lastName("Wraight").build();

        Book book1 = Book.builder()
                .title("The Killing Joke")
                .isbn("25-6443-212-54").pages(256)
                .authors(Collections.singletonList(author1))
                .build();

        Book book2 = Book.builder()
                .title("Legion")
                .isbn("78-6321-86-15").pages(411)
                .authors(Arrays.asList(author2, author3))
                .build();

        Book book3 = Book.builder()
                .title("Horus Rising")
                .isbn("786-613-455-87").pages(322)
                .authors(Arrays.asList(author2, author3, author4))
                .build();


        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);

        System.out.println("+++++++query by title++++++++++++++++++++");
        List<Book> books1 = bookRepo.queryByTitle("Legion");
        books1.forEach(System.out::println);

//        System.out.println("++++++++++++++ query by isbn ++++++++++++++++++");
//        Book queriedBook1 = bookRepo.findByIsbnIs("25-6443-212-54");
//        System.out.println(queriedBook1.toString());

        bookRepo.deleteAll();
    }
}
