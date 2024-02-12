package papillon.colibri.corbeau.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.entities.SauterelleEntity;
import papillon.colibri.corbeau.repositories.SauterelleRepository;

import java.util.Optional;

@Service
public class SauterelleService {
    private final ModelMapper modelMapper;
    private final SauterelleRepository sauterelleRepository;

    @Autowired
    public SauterelleService(ModelMapper modelMapper, SauterelleRepository sauterelleRepository) {
        this.modelMapper = modelMapper;
        this.sauterelleRepository = sauterelleRepository;
    }

    //Récupération de donnée en base = param -> repository -> BDD <- entity -> mapper -> dto -> controleur
    public SauterelleDTO getSauterelleById(Integer id){
        Optional<SauterelleEntity> sauterelleEntity = sauterelleRepository.findById(id);
        return sauterelleEntity.map(this::convertToDto).orElse(null);
    }

    //Envoi en base de donnée = dto -> mapper -> entity -> repository -> BDD
    public void createSauterelle(SauterelleDTO sauterelleDTO){
        SauterelleEntity sauterelleEntity = this.convertToEntity(sauterelleDTO);
        this.sauterelleRepository.save(sauterelleEntity);
    }

    public SauterelleDTO convertToDto(SauterelleEntity sauterelleEntity) {
        return modelMapper.map(sauterelleEntity, SauterelleDTO.class);
    }

    public SauterelleEntity convertToEntity(SauterelleDTO sauterelleDTO) {
        return modelMapper.map(sauterelleDTO, SauterelleEntity.class);
    }
}
