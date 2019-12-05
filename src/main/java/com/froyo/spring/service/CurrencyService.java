package com.froyo.spring.service;

import com.froyo.spring.model.dto.CurrencyRequest;
import com.froyo.spring.model.dto.CurrencyResponse;

public interface CurrencyService {

    CurrencyResponse saveCurrency(final CurrencyRequest currencyEntityDTO);

}
