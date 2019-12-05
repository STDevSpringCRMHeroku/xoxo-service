package com.froyo.spring.service.impl;

import com.froyo.spring.model.dto.CurrencyRequest;
import com.froyo.spring.model.dto.CurrencyResponse;
import com.froyo.spring.repository.CurrencyH2Repository;
import com.froyo.spring.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("currencyH2ServiceImpl")
public class CurrencyH2ServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyH2Repository currencyH2Repository;

    @Override
    public CurrencyResponse saveCurrency(final CurrencyRequest currencyEntityDTO) {
        return currencyH2Repository.saveCurrency(currencyEntityDTO);
    }


}
