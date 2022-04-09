package com.robot.apocalypse.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Survivors {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private Double latitude;
    private Double longitude;
    private Boolean infected;
    private Integer witnesses;
}
