package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class Album {
    private Artist artist;
    private List<Song> songs;
    private String name;
    private String year;
}
