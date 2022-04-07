package com.robot.apocalypse.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("robot")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RobotController {
    @GetMapping("/test-check")
    public String testCheck() {
        return "Service is very healthy.";
    }
}
