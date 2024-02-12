package papillon.colibri.corbeau.dto;

import lombok.Setter;
import lombok.Value;
import papillon.colibri.corbeau.entities.SauterelleEntity;

import java.io.Serializable;

/**
 * DTO for {@link SauterelleEntity}
 */
//Création de la DTO, qui pour l'exemple ne montrera pas le champ naissance, crée à partir de l'IDE Intellij, rajout de @Setter
@Value
@Setter
public class SauterelleDto implements Serializable {
    Byte id;
    String couleur;
}