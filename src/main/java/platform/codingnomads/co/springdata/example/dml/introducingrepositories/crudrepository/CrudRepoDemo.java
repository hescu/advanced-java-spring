package platform.codingnomads.co.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRepoDemo.class);
    }

    //autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        //create new user
        User user = User.builder().firstName("Bobby").lastName("Bobbert").age(56).build();
        User user2 = User.builder().firstName("Joanne").lastName("Joanna").age(36).build();
        User user3 = User.builder().firstName("Karl").lastName("Karlmann").age(22).build();
        User user4 = User.builder().firstName("Johann").lastName("Johannson").age(66).build();
        User user5 = User.builder().firstName("Kathy").lastName("Katty").age(77).build();


        //save user and assign what is returned to the user variable.
        Iterable<User> savedUsers = userRepo.saveAll(Arrays.asList(user, user2, user3, user4, user5));

        Iterable<User> users = userRepo.findAll();

        for(User u : users){
            System.out.println(u.toString());
        }

        //delete the user using the id of the inserted user object
        userRepo.deleteById(user.getId());
        userRepo.deleteById(user2.getId());

        for(User u : users){
            System.out.println(u.toString());
        }
    }
}
