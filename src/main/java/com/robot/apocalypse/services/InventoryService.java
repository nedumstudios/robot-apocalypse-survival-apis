package com.robot.apocalypse.services;

import com.robot.apocalypse.domain.Inventory;
import com.robot.apocalypse.models.InventoryEntity;
import com.robot.apocalypse.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final ModelMapper modelMapper;
    private final InventoryRepository repository;

    public Inventory save(Inventory inventory){
        return modelMapper.map(repository.save(modelMapper.map(inventory, InventoryEntity.class)), Inventory.class);
    }

    public List<Inventory> saveAll(Long survivorId, List<Inventory> inventories){
        List<Inventory> results = new ArrayList<>();

        for (var inventory : inventories) {
            inventory.setOwnerId(survivorId);
            results.add(save(inventory));
        }

        return results;
    }

    public List<Inventory> getInventoryBySurvivorId(Long survivorId){
        return repository.findAllByOwnerId(survivorId)
                .stream()
                .map(entity -> modelMapper.map(entity, Inventory.class))
                .collect(Collectors.toList());
    }
}
