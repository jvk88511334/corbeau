package papillon.colibri.corbeau.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.services.SauterelleService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SauterelleController.class)
@AutoConfigureMockMvc
public class SauterelleControllerTests {
    private final MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    SauterelleControllerTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Description("Mock de toutes les couches inférieures")
    @MockBean
    private SauterelleService sauterelleService;

    @Test
    void getSauterelleById() throws Exception {
        // Créer un objet SauterelleDTO pour le test
        SauterelleDTO sauterelleDTO = new SauterelleDTO();
        sauterelleDTO.setId(1);
        sauterelleDTO.setCouleur("noir");

        // Configurer le comportement de sauterelleService.getSauterelleById()
        when(sauterelleService.getSauterelleById(1)).thenReturn(sauterelleDTO);

        // Effectuer une requête GET /sauterelles/1 et vérifier le résultat
        mockMvc.perform(get("/sauterelles/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.couleur").value("noir"));
    }

    @Test
    void createSauterelle() throws Exception {
        // Créer un objet SauterelleDTO pour le test
        SauterelleDTO sauterelleDTO = new SauterelleDTO();
        sauterelleDTO.setCouleur("noir");

        // Configurer le comportement de sauterelleService.createSauterelle()
        doNothing().when(sauterelleService).createSauterelle(sauterelleDTO);

        // Effectuer une requête POST /sauterelles et vérifier le résultat
        mockMvc.perform(post("/sauterelles/create-sauterelle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sauterelleDTO)))
                .andExpect(status().isCreated());
    }
}
