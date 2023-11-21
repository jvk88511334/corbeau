package papillon.colibri.corbeau.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import papillon.colibri.corbeau.basetest.entity.SauterelleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test CRUD avec JDBC brut (JDBC Template) - bas niveau
 */

@Slf4j
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

        //Log des données de la table pour visualiser la donnée insérée
        List<SauterelleEntity> sauterelleEntities = jdbcTemplate.query("SELECT * FROM SAUTERELLE", new RowMapper<>() {
            @Override
            public SauterelleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                SauterelleEntity sauterelleEntity = new SauterelleEntity();
                sauterelleEntity.setNaissance(rs.getDate("NAISSANCE"));
                sauterelleEntity.setCouleur(rs.getString("COULEUR"));
                sauterelleEntity.setId(rs.getInt("ID"));
                return sauterelleEntity;
            }
        });
        log.info(sauterelleEntities.toString());

        //Suppression de la donnée
        int rowsCancelled = jdbcTemplate.update("DELETE FROM SAUTERELLE WHERE ID=?", -1);
        assertEquals(1, rowsCancelled);

        //Log des données de la table pour visualiser la donnée supprimée
        List<SauterelleEntity> sauterelleEntities2 = jdbcTemplate.query("SELECT * FROM SAUTERELLE", new RowMapper<>() {
            @Override
            public SauterelleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                SauterelleEntity sauterelleEntity = new SauterelleEntity();
                sauterelleEntity.setNaissance(rs.getDate("NAISSANCE"));
                sauterelleEntity.setCouleur(rs.getString("COULEUR"));
                sauterelleEntity.setId(rs.getInt("ID"));
                return sauterelleEntity;
            }
        });
        log.info(sauterelleEntities2.toString());
    }
}