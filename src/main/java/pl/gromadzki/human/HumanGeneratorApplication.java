package pl.gromadzki.human;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HumanGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanGeneratorApplication.class, args);
        Human human = new Human();
        human.cos();
    }

}
