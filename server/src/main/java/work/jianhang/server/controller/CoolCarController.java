package work.jianhang.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.jianhang.server.entity.Car;
import work.jianhang.server.repository.CarRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class CoolCarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cool-cars")
    public Collection<Car> coolCars() {
        return carRepository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
    }

    @GetMapping("/cars/{id}")
    public Car getCarsByid(@PathVariable String id) {
        return carRepository.findById(Long.valueOf(id)).get();
    }

    private boolean isCool(Car car) {
        return !Objects.equals(car.getName(), "AMC Gremlin") &&
                !Objects.equals(car.getName(), "Triumph Stag") &&
                !Objects.equals(car.getName(), "Ford Pinto") &&
                !Objects.equals(car.getName(), "Yugo GV");
    }
}
