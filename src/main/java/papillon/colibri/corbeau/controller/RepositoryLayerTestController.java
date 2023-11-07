package papillon.colibri.corbeau.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import papillon.colibri.corbeau.entity.CoursEntity;
import papillon.colibri.corbeau.repository.CoursRepository;

import java.util.Optional;

@RestController
@RequestMapping("/repositoryLayerTestController")
public class RepositoryLayerTestController {
    private final CoursRepository coursRepository;

    public RepositoryLayerTestController(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @GetMapping("/getRecord/{recordingId}")
    public void getRecord(@PathVariable Integer recordingId){
        System.out.println("/getRecord/{recordingId} -> request launched");
        Optional<CoursEntity> response = this.coursRepository.findById(recordingId);
        response.ifPresent(System.out::println);
    }
}
