package papillon.colibri.corbeau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import papillon.colibri.corbeau.dtos.SauterelleDTO;
import papillon.colibri.corbeau.services.SauterelleService;

@RestController
@RequestMapping("/sauterelles")
public class SauterelleController {
    private final SauterelleService sauterelleService;

    @Autowired
    public SauterelleController(SauterelleService sauterelleService) {
        this.sauterelleService = sauterelleService;
    }

    @GetMapping("/{sauterelleId}")
    public ResponseEntity<SauterelleDTO> getUser(@PathVariable Integer sauterelleId) {
        SauterelleDTO sauterelleDTO = sauterelleService.getSauterelleById(sauterelleId);
        return new ResponseEntity<>(sauterelleDTO, HttpStatus.OK);
    }
}
