package papillon.colibri.corbeau.dtos;

import lombok.*;
import papillon.colibri.corbeau.entities.SauterelleEntity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link SauterelleEntity}
 */
//Création de la DTO, qui pour l'exemple ne montrera pas le champ naissance, crée à partir de l'IDE Intellij, rajout de @Setter
//Dans le controleur, le retour de la DTO ne montrera pas le champ naissance, alors que dans JPAIntegrationTests les entités oui

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SauterelleDTO implements Serializable {
    Integer id;
    String couleur;
}

//Quand une sauterelle sera crée par le controleur qui envoie une SauterelleDTO, la date de naissance sera générée