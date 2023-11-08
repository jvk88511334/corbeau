package papillon.colibri.corbeau.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-repository-test.properties") //Branchement sur une base de donnée de test
class JdbcTemplateRequestsTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testInsertWithJdbcTemplateRequest() {
        //Insertion de la donnée
        int rowsAffected = jdbcTemplate.update("INSERT INTO SAUTERELLE (ID, COULEUR, NAISSANCE) VALUES (?, ?, ?)", -1, "vert", new Date());
        assertEquals(1, rowsAffected);
        //Suppression de la donnée
        int rowsCancelled = jdbcTemplate.update("DELETE FROM SAUTERELLE WHERE ID=?", -1);
        assertEquals(1, rowsCancelled);
    }
}