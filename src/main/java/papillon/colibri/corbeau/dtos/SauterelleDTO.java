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

//Quand une sauterelle sera crée par le controleur qui envoie une SauterelleDTO, la date de naissance sera générée, ici elle est cachée volontairement
//il suffit de placer     LocalDate naissance; dans la dto pour en autoriser l'envoi par l'interface
//et de mettre dans le JSON un champ "naissance" : "2022-03-15", pour envoyer une date au bon format
//sinon même si le client envoie une date, elle sera filtré par les règles présentes dans ModelMapperConfig