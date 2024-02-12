package papillon.colibri.corbeau.dtos;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;
import papillon.colibri.corbeau.entities.SauterelleEntity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link SauterelleEntity}
 */
//Création de la DTO, qui pour l'exemple ne montrera pas le champ naissance, crée à partir de l'IDE Intellij, rajout de @Setter
@Value
@Builder
public class SauterelleDTO implements Serializable {
    Integer id;
    String couleur;
}