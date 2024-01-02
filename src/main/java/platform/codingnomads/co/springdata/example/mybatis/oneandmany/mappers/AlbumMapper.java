package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Artist;

@Mapper
public interface AlbumMapper {
    @Insert("INSERT INTO mybatis.albums (name, bio) VALUES (#{name}, #{bio});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewArtist(Artist artist);
}
