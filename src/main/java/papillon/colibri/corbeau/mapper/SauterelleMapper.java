package papillon.colibri.corbeau.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import papillon.colibri.corbeau.dto.SauterelleDTO;
import papillon.colibri.corbeau.entities.SauterelleEntity;

/**
 * C'est une interface annotée avec @Mapper qui définit les méthodes pour convertir entre l'entité et le DTO.
 * MapStruct générera automatiquement l'implémentation de cette interface lors de la compilation
 */
@Mapper
public interface SauterelleMapper {
    SauterelleMapper INSTANCE = Mappers.getMapper(SauterelleMapper.class);
    SauterelleDTO sauterelleEntityToSauterelleDTO(SauterelleEntity sauterelleEntity);
    SauterelleEntity sauterelleDTOToSauterelleEntity(SauterelleDTO sauterelleDTO);
}
