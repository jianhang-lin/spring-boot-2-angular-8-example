package work.jianhang.server;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import work.jianhang.server.entity.Car;
import work.jianhang.server.repository.CarRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository carRepository) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
                Car exist = carRepository.findCarByName(name);
                if (exist == null) {
                    Car car = new Car();
                    car.setName(name);
                    carRepository.save(car);
                }
            });
            carRepository.findAll().forEach(System.out::println);
        };
    }
}
