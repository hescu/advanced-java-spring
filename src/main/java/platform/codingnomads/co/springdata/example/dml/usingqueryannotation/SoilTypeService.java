package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SoilTypeService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    public void getStuff() {
        System.out.println("****************GETTING STUFF********************");
        List<SoilType> allTheSoilTypes = soilTypeRepo.getSoilType();
        allTheSoilTypes.forEach(System.out::println);

        List<SoilType> soilTypesByPhValue = soilTypeRepo.getSoilTypeGreaterEqual7point5();
        soilTypesByPhValue.forEach(System.out::println);
    }
}
