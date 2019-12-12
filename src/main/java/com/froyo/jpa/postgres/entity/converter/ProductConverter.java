package com.froyo.jpa.postgres.entity.converter;

import com.froyo.AbstractConverter;
import com.froyo.dto.ProductDTO;
import com.froyo.jpa.postgres.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends AbstractConverter<ProductEntity, ProductDTO> {

    @Override
    public ProductEntity fromDto(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setEancode(dto.getEancode());
        entity.setDescription(dto.getDescription());
        entity.setUrlImage(dto.getUrlImage());

        return entity;
    }

    @Override
    public ProductDTO fromEntity(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setEancode(entity.getEancode());
        dto.setDescription(entity.getDescription());
        dto.setUrlImage(entity.getUrlImage());

        return dto;
    }
}
