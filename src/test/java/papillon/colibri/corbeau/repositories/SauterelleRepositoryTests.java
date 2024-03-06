package papillon.colibri.corbeau.repositories;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import papillon.colibri.corbeau.entities.SauterelleEntity;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
public class SauterelleRepositoryTests {
    private final SauterelleRepository sauterelleRepository;

    @Autowired
    public SauterelleRepositoryTests(SauterelleRepository sauterelleRepository) {
        this.sauterelleRepository = sauterelleRepository;
    }

    @Tag("integration")
    @Test
    void insertClassic(){
        sauterelleRepository.save(SauterelleEntity.builder().couleur("noir").naissance(LocalDate.now()).build());
        sauterelleRepository.save(SauterelleEntity.builder().couleur("bleu").naissance(LocalDate.now()).build());
        sauterelleRepository.findAll().forEach(el -> log.warn(String.valueOf(el)));
        sauterelleRepository.findByColor("bleu").forEach(el -> log.warn(String.valueOf(el)));
        sauterelleRepository.deleteAll();
        sauterelleRepository.findAll().forEach(el -> log.warn(String.valueOf(el)));
    }
}
