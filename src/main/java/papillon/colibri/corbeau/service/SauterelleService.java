package papillon.colibri.corbeau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import papillon.colibri.corbeau.dto.SauterelleDTO;
import papillon.colibri.corbeau.entities.SauterelleEntity;
import papillon.colibri.corbeau.mapper.SauterelleMapper;
import papillon.colibri.corbeau.repositories.SauterelleRepository;

import java.util.Optional;

@Service
public class SauterelleService {
    private final SauterelleMapper sauterelleMapper;
    private final SauterelleRepository sauterelleRepository;

    public SauterelleService(SauterelleMapper sauterelleMapper, SauterelleRepository sauterelleRepository) {
        this.sauterelleMapper = sauterelleMapper;
        this.sauterelleRepository = sauterelleRepository;
    }

    //Récupération de donnée en base = param -> repository -> BDD <- entity -> mapper -> dto -> controleur
    public SauterelleDTO getSauterelleById(Byte id){
        Optional<SauterelleEntity> sauterelleEntity = sauterelleRepository.findById((int)id);
        return sauterelleEntity.map(this.sauterelleMapper::sauterelleEntityToSauterelleDTO).orElse(null);
    }

    //Envoi en base de donnée = dto -> mapper -> entity -> repository -> BDD
    public void createSauterelle(SauterelleDTO sauterelleDTO){
        SauterelleEntity sauterelleEntity = sauterelleMapper.sauterelleDTOToSauterelleEntity(sauterelleDTO);
        this.sauterelleRepository.save(sauterelleEntity);
    }
}
