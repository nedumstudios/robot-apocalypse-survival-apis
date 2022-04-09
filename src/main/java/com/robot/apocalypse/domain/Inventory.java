package com.robot.apocalypse.domain;

import lombok.Data;

@Data
public class Inventory {
    private Long id;
    private String itemName;
    private Integer quantity;
    private Long ownerId;
}
