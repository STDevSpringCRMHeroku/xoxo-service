package com.froyo.service.impl;

import com.froyo.dto.ProductDTORequest;
import com.froyo.dto.ProductDTOResponse;
import com.froyo.jpa.postgres.entity.ProductEntity;
import com.froyo.jpa.postgres.entity.converter.ProductConverter;
import com.froyo.jpa.postgres.repository.ProductRepository;
import com.froyo.messages.MessagePairUtils;
import com.froyo.messages.codes.CurrencyMessageCode;
import com.froyo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductDTOResponse saveProduct(final ProductDTORequest productDTORequest) {

        ProductDTOResponse productDTOResponse = new ProductDTOResponse();

        ProductEntity productEntity = new ProductEntity();
        productEntity.setEancode(productDTORequest.getEancode());
        productEntity.setDescription(productDTORequest.getDescription());
        productEntity.setUrlImage(productDTORequest.getUrlImage());

        ProductEntity returnEntity = productRepository.save(productEntity);

        productDTOResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));
        productDTOResponse.setProductDTO(productConverter.fromEntity(productEntity));

        return productDTOResponse;
    }

    @Override
    public ProductDTOResponse findByEancode(String eancode){
        ProductDTOResponse productDTOResponse = new ProductDTOResponse();

        Optional<ProductEntity> optionalProductEntity = productRepository.findByEancode(eancode);
        ProductEntity productEntity = optionalProductEntity.orElse(new ProductEntity());

        productDTOResponse.setProductDTO(productConverter.fromEntity(productEntity));

        return productDTOResponse;
    }

}
