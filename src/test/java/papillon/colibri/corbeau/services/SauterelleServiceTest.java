package papillon.colibri.corbeau.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.entities.SauterelleEntity;
import papillon.colibri.corbeau.repositories.SauterelleRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SauterelleServiceTest {
    private SauterelleService sauterelleService;
    @Mock
    private SauterelleRepository sauterelleRepository;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sauterelleService = new SauterelleService(modelMapper, sauterelleRepository);
    }

    @Test
    void getSauterelleById() {
        // Créer une entité SauterelleEntity
        SauterelleEntity sauterelleEntity = new SauterelleEntity();
        sauterelleEntity.setId(1);
        sauterelleEntity.setCouleur("bleu");

        // Créer un DTO SauterelleDTO
        SauterelleDTO sauterelleDTO = new SauterelleDTO();
        sauterelleDTO.setId(1);
        sauterelleDTO.setCouleur("bleu");

        // Configurer le mock de SauterelleRepository pour renvoyer l'entité SauterelleEntity lorsque la méthode findById est appelée
        when(sauterelleRepository.findById(1)).thenReturn(Optional.of(sauterelleEntity));

        // Configurer le mock de ModelMapper pour renvoyer le DTO SauterelleDTO lorsque la méthode map est appelée
        when(modelMapper.map(sauterelleEntity, SauterelleDTO.class)).thenReturn(sauterelleDTO);

        // Appeler la méthode getSauterelleById du service
        SauterelleDTO result = sauterelleService.getSauterelleById(1);

        // Vérifier que le DTO renvoyé est bien celui attendu
        assertEquals(sauterelleDTO, result);

        // Vérifier que la méthode findById a été appelée une seule fois sur le mock de SauterelleRepository
        verify(sauterelleRepository, times(1)).findById(1);

        // Vérifier que la méthode map a été appelée une seule fois sur le mock de ModelMapper
        verify(modelMapper, times(1)).map(sauterelleEntity, SauterelleDTO.class);
    }

    @Test
    void createSauterelle() {

    }

    @Test
    void getAllSauterelles() {
    }

    @Test
    void deleteAllSauterelles() {
    }
}