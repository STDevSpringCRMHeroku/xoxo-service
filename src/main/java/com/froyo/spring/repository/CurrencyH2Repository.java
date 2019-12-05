package com.froyo.spring.repository;

import com.froyo.spring.model.dto.CurrencyRequest;
import com.froyo.spring.model.dto.CurrencyResponse;

public interface CurrencyH2Repository {
    CurrencyResponse saveCurrency(CurrencyRequest currencyEntityDTO);
}
