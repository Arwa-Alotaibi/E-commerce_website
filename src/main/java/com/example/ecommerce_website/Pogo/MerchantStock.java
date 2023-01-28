package com.example.ecommerce_website.Pogo;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotNull(message = "id should be not null")
    @Min(value = 3 , message = "id have to be 3 character long")
    private int id ;


    @NotNull(message = "product id should be not null")
    @Min(value = 3 , message = "product id have to be 3 character long")
    private int productid;

    @NotNull(message = "merchant id should be not null")
    @Min(value = 3 , message = "merchant id have to be 3 character long")
    private int merchantid;


    @NotNull(message = "stock should be not null")
    @Min(value = 10 , message = "have to be more than 10 at start ")
    private int stock;
}
