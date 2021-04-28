package com.feedback.website.controllers;

import com.feedback.website.dtos.TargetDto;
import com.feedback.website.mappers.TargetMapper;
import com.feedback.website.services.TargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "targets")
public class TargetController {

    private final TargetService targetService;


    @GetMapping(value = "/{id}")
    public TargetDto one(@PathVariable int id){
        return targetService.getOneTarget(id);
    }

    @GetMapping(value = "/")
    public List<TargetDto> all(){
        return targetService.getAllTargets();
    }

    @PostMapping(value = "/")
    public ResponseEntity<TargetDto> createTarget(@RequestBody TargetDto targetDto) {
        targetService.saveTarget(targetDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(targetDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateTarget(@RequestBody TargetDto targetDto, @PathVariable int id){
         targetService.updateTarget(targetDto,id);
        return ResponseEntity
                .ok("target id=" + id + " updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteTarget(@PathVariable int id){
        targetService.deleteTarget(id);
        return ResponseEntity
                .ok("target id=" + id + " deleted");

        //todo asagdaki kimi olanda error olmur, kod 204 qaytarir amma bodyye "user" 4 deleted yazmir
//        return ResponseEntity
//                .status(HttpStatus.NO_CONTENT)
//                .body("user" +id + "deleted");
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Object> deleteAllUsers() {
        targetService.deleteAllTargets();
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

