package com.robot.apocalypse.controller;

import com.robot.apocalypse.domain.Robot;
import com.robot.apocalypse.services.RobotService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("robot/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class RobotController {
    private final RobotService robotService;

    @GetMapping("find/{category}")
    @Operation(description = "This method is used to filter all Robots with their category.")
    public ResponseEntity<List<Robot>> getRobotsByCategory(@PathVariable final String category) {
        return ResponseEntity.ok(robotService.getAllRobot(category));
    }

    @GetMapping()
    @Operation(description = "This method is used to get all Robots.")
    public ResponseEntity<List<Robot>> getRobots() {
        return ResponseEntity.ok(robotService.getAllRobot());
    }
}
