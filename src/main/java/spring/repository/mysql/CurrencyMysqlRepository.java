package spring.repository.mysql;

import com.froyo.spring.model.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyMysqlRepository extends JpaRepository<CurrencyEntity, Long> {
    //...
}
