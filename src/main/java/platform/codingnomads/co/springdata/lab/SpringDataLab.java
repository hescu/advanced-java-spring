package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.PointOfInterestRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.models.PointOfInterest;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;
    private final PointOfInterestRepository pointOfInterestRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().isEmpty()) {
            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build(),
                            Area.builder().code("A").build(),
                            Area.builder().code("B").build(),
                            Area.builder().code("M").build(),
                            Area.builder().code("K").build()
                    )
            );
        }

        if (routeRepository.findAll().isEmpty()) {
            final List<Route> routes = routeRepository.saveAll(
                    Arrays.asList(
                            Route.builder().origin(areaRepository.findByCode("G"))
                                    .destination(areaRepository.findByCode("H")).build(),
                            Route.builder().origin(areaRepository.findByCode("Y"))
                                    .destination(areaRepository.findByCode("Z")).build(),
                            Route.builder().origin(areaRepository.findByCode("H"))
                                    .destination(areaRepository.findByCode("Y")).build(),
                            Route.builder().origin(areaRepository.findByCode("A"))
                                    .destination(areaRepository.findByCode("K")).build(),
                            Route.builder().origin(areaRepository.findByCode("B"))
                                    .destination(areaRepository.findByCode("M")).build(),
                            Route.builder().origin(areaRepository.findByCode("M"))
                                    .destination(areaRepository.findByCode("G")).build()
                    )
            );
        }

        if (pointOfInterestRepository.findAll().isEmpty()) {

            PointOfInterest poi1 = new PointOfInterest("Tanke", "Shell",
                    areaRepository.findByCode("A"));
            poi1.addRoutes(routeRepository.findAllByCodeContaining("A"));

            PointOfInterest poi2 = new PointOfInterest("Diner", "Moustache meets Food",
                    areaRepository.findByCode("Z"));
            poi2.addRoutes(routeRepository.findAllByCodeContaining("Z"));

            PointOfInterest poi3 = new PointOfInterest("Restaurant", "Good Morning, Vietnam",
                    areaRepository.findByCode("M"));
            poi3.addRoutes(routeRepository.findAllByCodeContaining("M"));

            PointOfInterest poi4 = new PointOfInterest("Restaurant", "Poldi's",
                    areaRepository.findByCode("K"));
            poi4.addRoutes(routeRepository.findAllByCodeContaining("K"));

            PointOfInterest poi5 = new PointOfInterest("Roadside Attraction", "Rock",
                    routeRepository.findByCode("M-G"));
            PointOfInterest poi6 = new PointOfInterest("Roadside Attraction", "Door to Hell",
                    routeRepository.findByCode("A-K"));

            final List<PointOfInterest> poiList = pointOfInterestRepository.saveAll(
                    List.of(poi1, poi2, poi3, poi4, poi5, poi6)
            );
        }

        System.out.println(pointOfInterestRepository.findAllByArea_code("A"));
        System.out.println(pointOfInterestRepository.findAllDistinctByRoutes_codeContaining("A"));

        System.out.println(areaRepository.findAllByPointsOfInterest_typeIgnoreCase("gas station"));
        System.out.println(areaRepository.findByCode("A"));

        System.out.println(routeRepository.findByOrigin_code("M"));
        System.out.println(routeRepository.findByOrigin_code("Y"));
        System.out.println(routeRepository.findByOrigin_code("H"));

        System.out.println(routeRepository.findByDestination_code("G"));
        System.out.println(routeRepository.findByDestination_code("M"));
        System.out.println(routeRepository.findByDestination_code("K"));

        System.out.println(routeRepository.findByCode("G-H"));
        System.out.println(routeRepository.findByCode("Y-Z"));
        System.out.println(routeRepository.findByCode("B-M"));

    }
}
