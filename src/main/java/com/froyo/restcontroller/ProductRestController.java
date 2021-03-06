package com.froyo.restcontroller;

import com.froyo.dto.ProductDTORequest;
import com.froyo.dto.ProductDTOResponse;
import com.froyo.service.ProductService;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.EAN;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/save")
    public ProductDTOResponse saveProduct(@RequestBody @Valid ProductDTORequest productDTORequest) {
        return productService.saveProduct(productDTORequest);
    }

    /**
     * EAN = International Article Number (also known as European Article Number or EAN)
     */
    @GetMapping("/retrieveByEancode")
    public ProductDTOResponse findByEancode(
            @RequestParam(name = "eancode")
            @NotNull
            @EAN(type = EAN.Type.EAN13) String eancode
    ) {
        return productService.findByEancode(eancode);
    }

}
