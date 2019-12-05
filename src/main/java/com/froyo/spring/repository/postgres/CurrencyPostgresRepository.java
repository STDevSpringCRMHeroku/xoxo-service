package com.froyo.spring.repository.postgres;

import com.froyo.spring.model.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyPostgresRepository extends JpaRepository<CurrencyEntity, Long> {
    //...
}
