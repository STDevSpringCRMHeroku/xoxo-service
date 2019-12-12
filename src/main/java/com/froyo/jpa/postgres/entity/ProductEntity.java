package com.froyo.jpa.postgres.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Each product will be given an auto-generated unique identifier when stored.

    @Column(name = "eancode", nullable = false, unique = true)
    private String eancode;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "urlImage", nullable = true)
    private String urlImage;

}
