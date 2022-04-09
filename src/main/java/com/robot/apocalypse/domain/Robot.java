package com.robot.apocalypse.domain;

import lombok.Data;

@Data
public class Robot {
    private String model;
    private String serialNumber;
    private String manufacturedDate;
    private String category;
}
