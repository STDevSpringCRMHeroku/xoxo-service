package com.froyo.spring.model.dto;

import com.froyo.messages.AbstractResponse;
import lombok.Data;

@Data
public class CurrencyResponseDTO extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    CurrencyRequestDTO currencyRequestDTO = new CurrencyRequestDTO();

}
