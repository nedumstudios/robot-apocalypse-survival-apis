package com.robot.apocalypse.domain;

import lombok.Data;

@Data
public class Witness {
    private Long id;
    private Long witnessId;
    private Long infectedId;
    private String comment;
    private Boolean processStatus;
}
