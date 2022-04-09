package com.robot.apocalypse.models;

import com.robot.apocalypse.config.AuditModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROBOTS")
public class RobotEntity extends AuditModel {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @Column(name = "MANUFACTURED_DATE")
    private String manufacturedDate;

    @Column(name = "CATEGORY")
    private String category;

}
