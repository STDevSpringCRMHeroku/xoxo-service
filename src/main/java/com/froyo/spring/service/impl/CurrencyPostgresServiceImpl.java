package com.froyo.spring.service.impl;

import com.froyo.messages.MessagePairUtils;
import com.froyo.messages.codes.CurrencyMessageCode;
import com.froyo.spring.model.dto.CurrencyRequestDTO;
import com.froyo.spring.model.dto.CurrencyResponseDTO;
import com.froyo.spring.model.entity.CurrencyEntity;
import com.froyo.spring.repository.postgres.CurrencyPostgresRepository;
import com.froyo.spring.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("currencyPostgresServiceImpl")
public class CurrencyPostgresServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyPostgresRepository currencyPostgresRepository;

    @Override
    public CurrencyResponseDTO saveCurrency(final CurrencyRequestDTO currencyRequest) {

        CurrencyResponseDTO currencyResponseDTO = new CurrencyResponseDTO();

        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrency(currencyRequest.getCurrency());

        currencyPostgresRepository.save(currencyEntity);
        currencyResponseDTO.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));

        return currencyResponseDTO;
    }

}
