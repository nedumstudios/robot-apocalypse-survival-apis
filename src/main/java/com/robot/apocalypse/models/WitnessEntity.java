package com.robot.apocalypse.models;

import com.robot.apocalypse.config.AuditModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "WITNESSES")
public class WitnessEntity extends AuditModel {
    @Column(name = "WITNESS_ID")
    private Long witnessId;

    @Column(name = "INFECTED_ID")
    private Long infectedId;

    @Column(name = "STATUS")
    private Boolean processStatus;

    @Column(name = "COMMENT")
    private String comment;
}
