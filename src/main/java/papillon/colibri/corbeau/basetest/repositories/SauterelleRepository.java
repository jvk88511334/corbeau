package papillon.colibri.corbeau.basetest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import papillon.colibri.corbeau.basetest.entities.SauterelleEntity;

//Implémente automatiquement par héritage les méthodes suivantes :
//https://docs.spring.io/spring-data/relational/reference/repositories/core-concepts.html
@Repository
public interface SauterelleRepository extends CrudRepository<SauterelleEntity, Integer> {

}
