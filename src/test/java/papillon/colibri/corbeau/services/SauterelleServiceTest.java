package papillon.colibri.corbeau.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.entities.SauterelleEntity;

import static org.junit.jupiter.api.Assertions.*;

class SauterelleServiceTest {
    private SauterelleDTO sauterelleDTO;
    private SauterelleEntity sauterelleEntity;

    @BeforeEach
    void setUp() {
        sauterelleDTO = SauterelleDTO.builder().couleur("vert").build();
    }

    @Test
    void convertToDto() {

    }

    @Test
    void convertToEntity() {
    }
}