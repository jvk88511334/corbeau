package papillon.colibri.corbeau.basetest.repository;

import org.springframework.data.repository.CrudRepository;
import papillon.colibri.corbeau.basetest.entity.SauterelleEntity;

import java.util.Optional;

public interface SauterelleRepository extends CrudRepository<SauterelleEntity, Integer> {
    Optional<SauterelleEntity> findSauterelleEntityByCouleur(String couleur);
}
