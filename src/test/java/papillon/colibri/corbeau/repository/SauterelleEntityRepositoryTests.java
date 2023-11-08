package papillon.colibri.corbeau.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import papillon.colibri.corbeau.basetest.entity.SauterelleEntity;
import papillon.colibri.corbeau.basetest.repository.SauterelleRepository;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-repository-test.properties")
class SauterelleRepositoryTests {
    @Autowired
    private SauterelleRepository sauterelleRepository;
    @Test
    void testSaveEntity(){
        //Insertion d'une entité (l'id est géré par la base de donnée)
        SauterelleEntity entityToSave = new SauterelleEntity();
        entityToSave.setCouleur("%r~T?f-53gw0+!,");
        entityToSave.setNaissance(new Date());
        SauterelleEntity entitySaved = sauterelleRepository.save(entityToSave);
        assertEquals("%r~T?f-53gw0+!,", entitySaved.getCouleur());

        //Lecture d'une entité à partir d'une donnée invariable (pas l'id)
        Optional<SauterelleEntity> entityResult = sauterelleRepository.findSauterelleEntityByCouleur("%r~T?f-53gw0+!,");
        assertTrue(entityResult.isPresent()); //Présence
        assertEquals("%r~T?f-53gw0+!,", entityResult.get().getCouleur()); //Donnée

        //Suppression d'une entité
        sauterelleRepository.delete(entityResult.get());
        assertFalse(sauterelleRepository.findSauterelleEntityByCouleur("%r~T?f-53gw0+!,").isPresent());
    }
}
