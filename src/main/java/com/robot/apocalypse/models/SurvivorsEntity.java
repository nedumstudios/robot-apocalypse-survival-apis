package com.robot.apocalypse.models;

import com.robot.apocalypse.config.AuditModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SURVIVORS")
public class SurvivorsEntity extends AuditModel {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "LAT")
    private Double latitude;

    @Column(name = "LONG")
    private Double longitude;

    @Column(name = "INFECTED")
    private Boolean infected;

    @Column(name = "WITNESSES")
    private Integer witnesses;
}
