package com.robot.apocalypse.repository;

import com.robot.apocalypse.models.RobotEntity;
import com.robot.apocalypse.models.WitnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WitnessRepository extends JpaRepository<WitnessEntity, Long> {
    List<WitnessEntity> findAllByStatusIsNotTrue();
}
