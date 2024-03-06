package papillon.colibri.corbeau.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.entities.SauterelleEntity;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
@EnableJpaRepositories(basePackageClasses = {
        papillon.colibri.corbeau.entities.SauterelleEntity.class,
        papillon.colibri.corbeau.repositories.SauterelleRepository.class
})
class ModelMapperTest {
    SauterelleDTO sauterelleDTO;
    SauterelleEntity sauterelleEntity;
    private final ModelMapper modelMapper;
    private TestReporter testReporter;

    @Autowired
    ModelMapperTest(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @BeforeEach
    void setUp() {
        sauterelleDTO = SauterelleDTO.builder().couleur("bleu").build();
        sauterelleEntity = SauterelleEntity.builder().build();
    }

    @BeforeEach
    void init(TestReporter testReporter) {
        this.testReporter = testReporter;
    }

    //Contrôle que les règles de CONVERSION écrites dans ModelMapperConfig s'appliquent bien
    @DisplayName("Test de conversion entre DTO et Entity")
    @Test
    void convertToDto(TestReporter testReporter) {
        SauterelleDTO target = this.modelMapper.map(sauterelleEntity, SauterelleDTO.class);
        displayObjects(sauterelleEntity, target);
        assert target.getCouleur().equals("noir");
    }

    @DisplayName("Test de conversion entre Entity et DTO")
    @Test
    void convertToEntity() {
        SauterelleEntity target = this.modelMapper.map(sauterelleDTO, SauterelleEntity.class);
        displayObjects(sauterelleDTO, target);
        assert target.getCouleur().equals("BLEU");
    }

    private void displayObjects(Object o1, Object o2) {
        testReporter.publishEntry("\u001B[31m" + o1.toString() + "\u001B[0m");
        testReporter.publishEntry("\u001B[32m" + o2.toString() + "\u001B[0m");
    }
}