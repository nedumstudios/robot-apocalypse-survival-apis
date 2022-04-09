package com.robot.apocalypse.controller;

import com.robot.apocalypse.domain.CreateSurvivors;
import com.robot.apocalypse.domain.SurvivorStats;
import com.robot.apocalypse.domain.Survivors;
import com.robot.apocalypse.services.SurvivorsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("survival/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class SurvivalController {
    private final SurvivorsService survivorsService;

    @PostMapping()
    @Operation(description = "Register survivors to the system.")
    public ResponseEntity<CreateSurvivors> createSurvivors(@RequestBody final CreateSurvivors survivors){
        return ResponseEntity.ok(survivorsService.saveSurvivor(survivors));
    }

    @PutMapping("{id}/{longitude}/{latitude}")
    @Operation(description = "Update survivors location.")
    public ResponseEntity<Survivors> updateSurvivorById(@PathVariable final Long id, @PathVariable final Double latitude, @PathVariable final Double longitude){
        return ResponseEntity.ok(survivorsService.updateSurvivorsLocation(id, latitude, longitude));
    }

    @GetMapping("{id}")
    @Operation(description = "Method to get a survivor information.")
    public ResponseEntity<Survivors> getSurvivorById(@PathVariable final Long id){
        return ResponseEntity.ok(survivorsService.getSurvivor(id));
    }

    @GetMapping("infected")
    @Operation(description = "Method to pull all infected survivors in the system.")
    public ResponseEntity<List<Survivors>> getInfectSurvivors(){
        return ResponseEntity.ok(survivorsService.getAllInfectedSurvivors());
    }

    @GetMapping("non-infected")
    @Operation(description = "Method to pull all non-survivors in the system.")
    public ResponseEntity<List<Survivors>> getNonInfectSurvivors(){
        return ResponseEntity.ok(survivorsService.getAllNonInfectedSurvivors());
    }

    @GetMapping("statistics")
    @Operation(description = "Method to get survivors statistics percentage of non-infected and infected.")
    public ResponseEntity<SurvivorStats> getSurvivorStatistics(){
        return ResponseEntity.ok(survivorsService.getSurvivorStats());
    }

}
