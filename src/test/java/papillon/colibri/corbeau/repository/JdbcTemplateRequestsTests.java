package papillon.colibri.corbeau.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
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

@Slf4j //journalisation simplifiée avec lombok (requiers la dépendance lombok dans le pom)
@SpringBootTest //crée un contexte d'application et charge un contexte d'application complet pour les tests, permet notamment les @Autowired dans une classe de test (dépendance spring-boot-starter-test)
@ActiveProfiles("test") //seul les beans associés au profil “test” seront instanciés dans le contexte d’application pour les tests
@TestPropertySource("classpath:application-repository-test.properties") //Branchement sur une base de donnée de test
class JdbcTemplateRequestsTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Test d'insertion simple avec JDBC sans jointure
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
        this.console(sauterelleEntities.toString());

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
        this.console(sauterelleEntities2.toString());
    }

    //Test d'insertion complexe avec JDBC avec jointure
    @Test
    void testInsertDataWithJoinsWithJdbcTemplateRequest() {
        //Creation d'un panier
        jdbcTemplate.update("INSERT INTO panier (ID, NEUF) VALUES(3, false)");
        //Insertion de la jointure : création et rattachement du grillon au panier n°3
        jdbcTemplate.update("INSERT INTO grillon (ID, COULEUR, NAISSANCE, ID_1, ID_2) VALUE (?,?,?,?,?)", -1, "brun", new Date(2023, 12, 01), null, 3);
        //Insertion de la jointure : création d'une patte rattachée au grillon portant l'id -1
        jdbcTemplate.update("INSERT INTO patte (ID, ID_1) VALUE (?, ?)", 1,-1);

        //Rajout d'un grillon noir avec l'id -2 sans pattes en couple avec le grillon brun, dans le panier n°3
        jdbcTemplate.update("INSERT INTO grillon (ID, COULEUR, NAISSANCE, ID_1, ID_2) VALUE (?,?,?,?,?)", -2, "noir", new Date(2023, 10, 05), -1, 3);

        //Log du grillon avec les jointures, utilisation d'un RowCallBackHandler en lambda pour ne pas utiliser d'objet intermédiaire (pas d'entité nécessaire par rapport à Sauterelle)
        jdbcTemplate.query("SELECT * FROM GRILLON", rs -> {
            console(rs.toString());
            do{
                console("ID "+rs.getString(1));
                console("COULEUR "+rs.getString(2));
                console("ID_1=grillon(ID) "+rs.getString(4));
                console("ID_2=panier(ID) "+rs.getString(5));
                console("");
            } while (rs.next());
        });

        //Respect des contraintes d'intégrités pour la suppression des données (ordre des suppressions)
        jdbcTemplate.update("DELETE from patte where ID=?", 1);
        jdbcTemplate.update("DELETE from grillon where ID=?", -2);
        jdbcTemplate.update("DELETE from grillon where ID=?", -1);
        jdbcTemplate.update("DELETE from panier where ID=?", 3);
    }

    private void console(String stringToColor){
        log.info("\u001B[34m" + "\u001B[1m" + stringToColor + "\u001B[0m");
    }

}