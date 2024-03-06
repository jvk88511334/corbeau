package papillon.colibri.corbeau.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.entities.SauterelleEntity;

import java.time.LocalDate;
import java.util.Objects;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        //Mapping DTO -> Entity
        modelMapper.createTypeMap(SauterelleDTO.class, SauterelleEntity.class)
                .setPostConverter(context -> {
                    SauterelleDTO source = context.getSource();
                    SauterelleEntity destination = context.getDestination();

                    //DTO valeur null -> Entity valeur par defaut
                    if (destination.getNaissance() == null) {
                        destination.setNaissance(LocalDate.now());
                    }

                    //DTO valeur spécifique -> conversion -> Entity autre valeur
                    if (Objects.equals(source.getCouleur(), "bleu")) {
                        destination.setCouleur(source.getCouleur().toUpperCase());
                    }
                    return destination;
                });

        //Mapping Entity -> DTO
        modelMapper.createTypeMap(SauterelleEntity.class, SauterelleDTO.class)
                .setPostConverter(context -> {
                    SauterelleEntity source = context.getSource();
                    SauterelleDTO destination = context.getDestination();

                    //Entity valeur null -> DTO valeur par defaut
                    if (source.getCouleur() == null) {
                        destination.setCouleur("noir");
                    }
                    return destination;
                });

        modelMapper.validate();
        return modelMapper;
    }
}
