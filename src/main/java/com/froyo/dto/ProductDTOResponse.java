package com.froyo.dto;

import com.froyo.messages.AbstractResponse;
import lombok.Data;

@Data
public class ProductDTOResponse extends AbstractResponse {

    private ProductDTO productDTO;

}
