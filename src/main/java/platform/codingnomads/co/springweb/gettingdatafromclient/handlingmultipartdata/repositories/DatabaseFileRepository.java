package platform.codingnomads.co.springweb.gettingdatafromclient.handlingmultipartdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import platform.codingnomads.co.springweb.gettingdatafromclient.handlingmultipartdata.models.DatabaseFile;

import java.util.List;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {
    @Query("SELECT f FROM DatabaseFile f WHERE f.fileName LIKE %:name%")
    List<DatabaseFile> findByName(String name);
//    List<DatabaseFile> findByFileName(String name);
}
