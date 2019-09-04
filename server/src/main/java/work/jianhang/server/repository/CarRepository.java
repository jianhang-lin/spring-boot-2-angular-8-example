package work.jianhang.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.jianhang.server.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByName(String name);
}
