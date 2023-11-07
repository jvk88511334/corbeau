package papillon.colibri.corbeau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import papillon.colibri.corbeau.entity.CoursEntity;
import papillon.colibri.corbeau.record.CoursRecord;
import papillon.colibri.corbeau.service.CoursService;

import java.util.Optional;

@RestController
@RequestMapping("/coursController")
public class CoursController {
    private final CoursService coursService;

    @Autowired
    public CoursController(CoursService coursService){
        this.coursService = coursService;
    }

    //getRecord?number=1
    @GetMapping("/getRecord")
    public CoursRecord getCoursRecordByRequestParam(@RequestParam(value = "number", defaultValue = "1") Integer recordingId){
       return this.coursService.findById(recordingId);
    }

    //getRecord/1
    @GetMapping("/getRecord/{recordingId}")
    public CoursRecord getCoursRecordByPathVariable(@PathVariable Integer recordingId){
        return this.coursService.findById(recordingId);
    }

    @GetMapping("/databaseTest")
    public String datatest(){
        coursService.launchRequest();
        return "test";
    }
}
