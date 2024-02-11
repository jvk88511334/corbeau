package papillon.colibri.corbeau.jdbc_spring_data;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import papillon.colibri.corbeau.basetest.entities.SauterelleEntity;
import papillon.colibri.corbeau.basetest.repositories.SauterelleRepository;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-repository-test.properties")
@ComponentScan("papillon.colibri.corbeau")
public class JdbcSpringDataClassicTests {
    private final SauterelleRepository sauterelleRepository;

    @Autowired
    public JdbcSpringDataClassicTests(SauterelleRepository sauterelleRepository) {
        this.sauterelleRepository = sauterelleRepository;
    }

    SauterelleEntity entityWithId;
    SauterelleEntity entityWithNoId;

    @BeforeEach
    void setUp() {
        //Les ID étant générés automatiquement, non recommandé d'instancier avec un ID en dur
        entityWithId = new SauterelleEntity((byte) 4,"rouge", LocalDate.of(2005, 10, 23));
        entityWithNoId = SauterelleEntity.builder().couleur("noir").naissance(LocalDate.of(2005, 10, 23)).build();
    }

    @Test
    void crudSauterelleEntity() {
        //C
        sauterelleRepository.save(entityWithId);
        sauterelleRepository.save(entityWithNoId);
        //R
        log.warn("elements added");
        sauterelleRepository.findAll().forEach(element -> log.warn(element.toString()));
        //UD
        sauterelleRepository.delete(entityWithId);
        sauterelleRepository.delete(entityWithNoId);
        //R
        log.warn("elements deleted");
        sauterelleRepository.findAll().forEach(element -> log.warn(element.toString()));
    }
}
