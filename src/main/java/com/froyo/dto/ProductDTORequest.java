package com.froyo.dto;

import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.EAN;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
public class ProductDTORequest implements Serializable {

    @NotNull
    @EAN(type = EAN.Type.EAN13)
    private String eancode;

    @NotNull
    private String description;

    private String urlImage;

}
