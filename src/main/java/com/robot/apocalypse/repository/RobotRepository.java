package com.robot.apocalypse.repository;

import com.robot.apocalypse.models.RobotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends JpaRepository<RobotEntity, Long> {
}
