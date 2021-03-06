package work.jianhang.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import work.jianhang.server.entity.Car;

@RepositoryRestController
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByName(String name);
}
