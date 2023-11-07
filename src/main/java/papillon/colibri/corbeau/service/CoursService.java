package papillon.colibri.corbeau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import papillon.colibri.corbeau.entity.CoursEntity;
import papillon.colibri.corbeau.record.CoursRecord;
import papillon.colibri.corbeau.repository.CoursRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class CoursService {
    private final CoursRepository coursRepository;

    @Autowired
    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    //C
    /*
    public CoursRecord insertOneRecord(CoursEntity coursEntity){
        return this.coursRepository.save(coursEntity);
    }
    */

    //Read one record
    public CoursRecord findById(Integer id){
        Optional<CoursEntity> coursEntityReturned = this.coursRepository.findById(id);
        if(coursEntityReturned.isPresent()){
            return new CoursRecord(
                    coursEntityReturned.get().getId(),
                    coursEntityReturned.get().getLibelle(),
                    coursEntityReturned.get().getDescription(),
                    coursEntityReturned.get().getMiseajour(),
                    coursEntityReturned.get().getId_1(),
                    coursEntityReturned.get().getId_2()
            );
        }else{
            return new CoursRecord(
                    -1,
                    "enregistrement non présent en base avec l'id: " + id,
                    "enregistrement non présent en base avec l'id: " + id,
                    new Date(System.currentTimeMillis()),
                    -1,
                    -1
            );
        }
    }

    //Read all records
    public Iterable<CoursEntity> findAll(){
        return this.coursRepository.findAll();
    }

    public void launchRequest(){
        System.out.println("launchrequest");
        Optional<CoursEntity> response = this.coursRepository.findById(1);
        if(response.isPresent()){
            System.out.println(response.get());
        }
    }
}
