package com.robot.apocalypse.models;

import com.robot.apocalypse.config.AuditModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "INVENTORIES")
public class InventoryEntity extends AuditModel {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "OWNER_ID")
    private Long ownerId;
}
