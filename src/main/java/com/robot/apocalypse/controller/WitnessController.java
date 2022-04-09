package com.robot.apocalypse.controller;

import com.robot.apocalypse.domain.Robot;
import com.robot.apocalypse.domain.Witness;
import com.robot.apocalypse.services.RobotService;
import com.robot.apocalypse.services.WitnessService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("witness/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class WitnessController {
    private final WitnessService witnessService;

    @PostMapping()
    @Operation(description = "Method to register an infected survivor with comments.")
    public ResponseEntity<Witness> addWitnessOfInfected(@RequestBody final Witness witness){
        return ResponseEntity.ok(witnessService.addWitnessOfInfected(witness));
    }

}
