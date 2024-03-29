package papillon.colibri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import papillon.colibri.dao.SauterelleDao;

import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);
        SauterelleDao.getAllUsers().forEach(System.out::println);
    }
}
