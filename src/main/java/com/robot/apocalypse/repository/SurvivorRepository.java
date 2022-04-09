package com.robot.apocalypse.repository;

import com.robot.apocalypse.domain.Survivors;
import com.robot.apocalypse.models.SurvivorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurvivorRepository extends JpaRepository<SurvivorsEntity, Long> {
    List<SurvivorsEntity> findAllByInfectedIsTrue();
    List<SurvivorsEntity> findAllByInfectedNotLike(boolean infected);
    Long countAllByInfectedIsTrue();
}
