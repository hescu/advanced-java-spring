package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.PointOfInterest;

import java.util.List;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    List<PointOfInterest> findAllByArea_code(String code);

    List<PointOfInterest> findAllDistinctByRoutes_codeContaining(String code);
}
