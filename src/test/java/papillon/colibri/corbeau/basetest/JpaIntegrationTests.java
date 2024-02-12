package papillon.colibri.corbeau.basetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import papillon.colibri.corbeau.entities.SauterelleEntity;
import papillon.colibri.corbeau.repositories.SauterelleRepository;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
public class JpaIntegrationTests {
    private final SauterelleRepository sauterelleRepository;

    @Autowired
    public JpaIntegrationTests(SauterelleRepository sauterelleRepository) {
        this.sauterelleRepository = sauterelleRepository;
    }

    @Test
    void insertClassic(){
        SauterelleEntity.builder().build();
        //sauterelleRepository.save(new SauterelleEntity("noir", LocalDate.now()));
        sauterelleRepository.save(SauterelleEntity.builder().couleur("noir").naissance(LocalDate.now()).build());
        sauterelleRepository.save(SauterelleEntity.builder().couleur("bleu").naissance(LocalDate.now()).build());
        sauterelleRepository.findAll().forEach(el -> log.warn(String.valueOf(el)));
        sauterelleRepository.findByColor("bleu").forEach(el -> log.warn(String.valueOf(el)));
        sauterelleRepository.deleteAll();
        sauterelleRepository.findAll().forEach(el -> log.warn(String.valueOf(el)));
    }
}
