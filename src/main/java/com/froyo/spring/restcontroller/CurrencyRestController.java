package com.froyo.spring.restcontroller;

import com.froyo.spring.model.dto.CurrencyRequestDTO;
import com.froyo.spring.model.dto.CurrencyResponseDTO;
import com.froyo.spring.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyRestController {

    @Autowired
    @Qualifier("currencyPostgresServiceImpl")
    private CurrencyService currencyPostgresService;

    @Autowired
    @Qualifier("currencyMysqlServiceImpl")
    private CurrencyService currencyMysqlServiceImpl;

    @PostMapping("/addCurrency")
    private CurrencyResponseDTO addCurrency(@RequestBody CurrencyRequestDTO currencyRequestDTO) {

        CurrencyResponseDTO result = new CurrencyResponseDTO();
        result.setCurrencyRequestDTO(currencyRequestDTO);

        CurrencyResponseDTO currencyResponseDTOP = currencyPostgresService.saveCurrency(currencyRequestDTO);
        result.getMessagePairList().addAll(currencyResponseDTOP.getMessagePairList());

        CurrencyResponseDTO currencyResponseDTOM = currencyMysqlServiceImpl.saveCurrency(currencyRequestDTO);
        result.getMessagePairList().addAll(currencyResponseDTOM.getMessagePairList());

        return result;
    }

}
