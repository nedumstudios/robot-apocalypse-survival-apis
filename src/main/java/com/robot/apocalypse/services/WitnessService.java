package com.robot.apocalypse.services;

import com.robot.apocalypse.domain.Robot;
import com.robot.apocalypse.domain.Witness;
import com.robot.apocalypse.models.WitnessEntity;
import com.robot.apocalypse.repository.WitnessRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WitnessService {
    private final WitnessRepository repository;
    private final ModelMapper modelMapper;
    private final SurvivorsService survivorsService;

    @Scheduled(cron  = "* * * * * *")
    public void checkAndUpdateInfected(){
        var infectedNotProcessed = repository.findAllByStatusIsNotTrue();

        for (var infected : infectedNotProcessed) {
            infected.setProcessStatus(true);

            var survivor = survivorsService.getSurvivor(infected.getInfectedId());
            var witnesses = survivor.getWitnesses();
            witnesses += 1;
            survivor.setWitnesses(witnesses);

            if(survivor.getWitnesses() > 3){
                survivor.setInfected(true);
            }
            survivorsService.save(survivor);
        }
    }

    public Witness addWitnessOfInfected(Witness witness){
        return modelMapper.map(repository.save(modelMapper.map(witness, WitnessEntity.class)), Witness.class);
    }
}
