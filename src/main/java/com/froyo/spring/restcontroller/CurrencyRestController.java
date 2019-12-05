package com.froyo.spring.restcontroller;

import com.froyo.spring.model.dto.CurrencyRequest;
import com.froyo.spring.model.dto.CurrencyResponse;
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
    private CurrencyResponse addCurrency(@RequestBody CurrencyRequest currencyRequest) {

        CurrencyResponse result = new CurrencyResponse();
        result.setCurrencyRequest(currencyRequest);

        CurrencyResponse currencyResponseP = currencyPostgresService.saveCurrency(currencyRequest);
        result.getMessagePairList().addAll(currencyResponseP.getMessagePairList());

        CurrencyResponse currencyResponseM = currencyMysqlServiceImpl.saveCurrency(currencyRequest);
        result.getMessagePairList().addAll(currencyResponseM.getMessagePairList());

        return result;
    }

}
