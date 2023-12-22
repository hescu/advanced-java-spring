package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song3 = new Song();
            song3.setName("Heat Waves");
            song3.setAlbum_name("Dreamland");
            song3.setArtist_name("Glass Animals");
            song3.setSong_length(237);

            Song song4 = new Song();
            song4.setName("Blinding Lights");
            song4.setAlbum_name("After Hours");
            song4.setArtist_name("The Weeknd");
            song4.setSong_length(200);

            Song song5 = new Song();
            song5.setName("Levitating");
            song5.setAlbum_name("Future Nostalgia");
            song5.setArtist_name("Dua Lipa");
            song5.setSong_length(203);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song3);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);

            Song returnedSong = songMapper.getSongById(1L);

            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);
            ArrayList<Song> shortSongs = songMapper.getSongsWithLengthShorterThan(250);
            ArrayList<Song> songsByName = songMapper.getSongsByName("Levitating");

            longSongs.forEach(System.out::println);
            shortSongs.forEach(System.out::println);
            songsByName.forEach(System.out::println);

            System.out.println(returnedSong.toString());
        };
    }
}
