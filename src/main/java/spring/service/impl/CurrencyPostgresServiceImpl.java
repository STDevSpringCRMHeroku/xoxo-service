package spring.service.impl;

import com.froyo.messages.MessagePairUtils;
import com.froyo.messages.codes.CurrencyMessageCode;
import com.froyo.spring.model.dto.CurrencyRequest;
import com.froyo.spring.model.dto.CurrencyResponse;
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
    public CurrencyResponse saveCurrency(final CurrencyRequest currencyRequest) {

        CurrencyResponse currencyResponse = new CurrencyResponse();

        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrency(currencyRequest.getCurrency());

        currencyPostgresRepository.save(currencyEntity);
        currencyResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));

        return currencyResponse;
    }

}
