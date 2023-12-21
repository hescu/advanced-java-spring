package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {
    @Query(value = "SELECT st FROM SoilType st")
    List<SoilType> getSoilType();

    @Query(value = "SELECT st FROM SoilType st WHERE ph >= 7.5")
    List<SoilType> getSoilTypeGreaterEqual7point5();
}
