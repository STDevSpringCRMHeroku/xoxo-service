package com.froyo.spring.model.dto;

import com.froyo.messages.AbstractResponse;
import lombok.Data;

@Data
public class CurrencyResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    CurrencyRequest currencyRequest = new CurrencyRequest();

}
