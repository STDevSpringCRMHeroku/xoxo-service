package com.froyo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
public class ProductDTO {

    private String eancode;
    private String description;

    //Using google photos
    private String urlImage;

}
