package papillon.colibri.corbeau.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "sauterelle", schema = "cn0qkvnh1b2cktjx")
public class SauterelleEntity {
    //Bien penser a controler en base de donnée que la case autoincrement est cochée sur la clé primaire
    //ALTER TABLE jaqnjd0v26f6djho.sauterelle MODIFY COLUMN ID tinyint(4) NOT NULL AUTO_INCREMENT,
    //ADD PRIMARY KEY (ID);
    //Règler son pool max de connections à + de 30
    //Controler pour les tests d'integ. continue sur le controleur principal d'être connecté en base de prod et non de test
    //Controler la présence d'une structure identique en base de test et de prod
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "COULEUR", nullable = false, length = 50)
    private String couleur;

    @Column(name = "NAISSANCE")
    private LocalDate naissance;
}