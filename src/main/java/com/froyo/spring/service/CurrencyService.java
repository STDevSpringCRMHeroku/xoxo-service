package com.froyo.spring.service;

import com.froyo.spring.model.dto.CurrencyRequestDTO;
import com.froyo.spring.model.dto.CurrencyResponseDTO;

public interface CurrencyService {

    CurrencyResponseDTO saveCurrency(final CurrencyRequestDTO currencyEntityDTO);

}
