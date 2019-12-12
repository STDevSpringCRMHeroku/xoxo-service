package com.froyo.service;

import com.froyo.dto.ProductDTORequest;
import com.froyo.dto.ProductDTOResponse;

public interface ProductService {

    ProductDTOResponse saveProduct(final ProductDTORequest productDTORequest);

    ProductDTOResponse findByEancode(String eancode);

}
