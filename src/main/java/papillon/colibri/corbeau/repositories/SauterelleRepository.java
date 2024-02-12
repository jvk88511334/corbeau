package papillon.colibri.corbeau.repositories;

import lombok.ToString;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import papillon.colibri.corbeau.entities.SauterelleEntity;

import java.util.List;

//JPA Repository fournit certaines méthodes de base, voir https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
@Repository
public interface SauterelleRepository extends JpaRepository<SauterelleEntity, Integer> {
    @Query("select e from SauterelleEntity e where e.couleur = :color")
    List<SauterelleEntity> findByColor(@Param("color") String color);
}
