package papillon.colibri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import papillon.colibri.dao.SauterelleDao;

import java.sql.SQLException;
import java.util.Objects;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);
        Objects.requireNonNull(SauterelleDao.getAllUsers()).forEach(System.out::println);
    }
}
