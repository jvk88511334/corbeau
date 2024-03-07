package papillon.colibri.corbeau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.services.SauterelleService;

import java.util.List;

@RestController
@RequestMapping("/sauterelles")
public class SauterelleController {
    private final SauterelleService sauterelleService;

    @Autowired
    public SauterelleController(SauterelleService sauterelleService) {
        this.sauterelleService = sauterelleService;
    }

    @GetMapping("/{sauterelleId}")
    public ResponseEntity<SauterelleDTO> getSauterelle(@PathVariable Integer sauterelleId) {
        SauterelleDTO sauterelleDTO = sauterelleService.getSauterelleById(sauterelleId);
        return new ResponseEntity<>(sauterelleDTO, HttpStatus.OK);
    }

    @PostMapping("/create-sauterelle")
    public ResponseEntity<Void> createSauterelle(@RequestBody SauterelleDTO sauterelleDTO) {
        sauterelleService.createSauterelle(sauterelleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/injectfortests")
    public ResponseEntity<Void> injectsauterelle() {
        sauterelleService.createSauterelle(SauterelleDTO.builder().couleur("vert").build());
        sauterelleService.createSauterelle(SauterelleDTO.builder().couleur("bleu").build());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/getallfortests")
    public ResponseEntity<List<SauterelleDTO>> getsauterelle() {
        List<SauterelleDTO> sauterelleDTO = sauterelleService.getAllSauterelles();
        return new ResponseEntity<>(sauterelleDTO, HttpStatus.OK);
    }

    @RequestMapping("/cleanallfortests")
    public ResponseEntity<Void> destructAllSauterelles() {
        sauterelleService.deleteAllSauterelles();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
