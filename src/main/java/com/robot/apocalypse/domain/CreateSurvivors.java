package com.robot.apocalypse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateSurvivors {
    private Survivors survivors;
    private List<Inventory> inventories;
}
