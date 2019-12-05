package com.froyo.spring.model.entity.listener;

import com.froyo.spring.model.entity.CurrencyEntity;
import lombok.extern.log4j.Log4j2;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

@Log4j2
public class CurrencyListener {

    @PrePersist
    public void salvar(CurrencyEntity currency) {
        log.info("save CURRENCY: " + currency.getCurrency());
    }

    @PreRemove
    public void borrar(CurrencyEntity currency) {
        log.info("remove CURRENCY: " + currency.getCurrency());
    }

}
