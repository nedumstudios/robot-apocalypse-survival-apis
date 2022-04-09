package com.robot.apocalypse.services;

import com.robot.apocalypse.domain.CreateSurvivors;
import com.robot.apocalypse.domain.SurvivorStats;
import com.robot.apocalypse.domain.Survivors;
import com.robot.apocalypse.models.SurvivorsEntity;
import com.robot.apocalypse.repository.SurvivorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurvivorsService {
    private final ModelMapper modelMapper;
    private final SurvivorRepository repository;
    private final InventoryService inventoryService;

    public Survivors save(Survivors survivors){
        return modelMapper.map(repository.save(modelMapper.map(survivors, SurvivorsEntity.class)), Survivors.class);
    }

    public CreateSurvivors saveSurvivor(CreateSurvivors createSurvivors){
        var saveSurvivors = save(createSurvivors.getSurvivors());

        return CreateSurvivors.builder()
                .survivors(saveSurvivors)
                .inventories(inventoryService.saveAll(saveSurvivors.getId(), createSurvivors.getInventories()))
                .build();
    }

    public CreateSurvivors getSurvivorsById(Long survivorId){
        return CreateSurvivors.builder()
                .survivors(getSurvivor(survivorId))
                .inventories(inventoryService.getInventoryBySurvivorId(survivorId))
                .build();
    }

    public Survivors getSurvivor(Long id){
        var survivor = repository.findById(id);
        return survivor.map(entity -> modelMapper.map(entity, Survivors.class)).orElse(null);
    }

    public List<Survivors> getAllInfectedSurvivors(){
        return repository.findAllByInfectedIsTrue()
                .stream()
                .map(entity -> modelMapper.map(entity, Survivors.class))
                .collect(Collectors.toList());
    }

    public List<Survivors> getAllNonInfectedSurvivors(){
        return repository.findAllByInfectedIsNotTrue()
                .stream()
                .map(entity -> modelMapper.map(entity, Survivors.class))
                .collect(Collectors.toList());
    }

    public SurvivorStats getSurvivorStats(){
        Long totalCount = repository.count();
        Long infectedCount = repository.countAllByInfectedIsTrue();
        Long nonInfected = totalCount - infectedCount;

        Double infectPercentage = (infectedCount/totalCount) * 100;
        SurvivorStats stats = new SurvivorStats();
    }

    public Survivors updateSurvivorsLocation(Long survivorId, Double latitude, Double longitude){
        var survivor = getSurvivor(survivorId);
        survivor.setLatitude(latitude);
        survivor.setLongitude(longitude);
        return save(survivor);
    }
}
