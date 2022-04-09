package com.robot.apocalypse.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robot.apocalypse.domain.Robot;
import com.robot.apocalypse.repository.RobotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RobotService {
    private final RestTemplate restTemplate;

    private final static String BASE_URL = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";

    public List<Robot> getAllRobot(String category){
        ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(BASE_URL, Robot[].class);
        Robot[] userArray = responseEntity.getBody();

        if(userArray == null || userArray.length < 1) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No record found!.");

        return Arrays.stream(userArray)
                .filter(entity -> category.equals(entity.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Robot> getAllRobot(){
        ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(BASE_URL, Robot[].class);
        Robot[] userArray = responseEntity.getBody();

        if(userArray == null || userArray.length < 1) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No record found!.");

        return Arrays
                .stream(userArray)
                .collect(Collectors.toList());
    }
}
