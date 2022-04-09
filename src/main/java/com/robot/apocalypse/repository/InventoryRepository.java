package com.robot.apocalypse.repository;

import com.robot.apocalypse.models.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    List<InventoryEntity> findAllByOwnerId(Long survivorId);
}
