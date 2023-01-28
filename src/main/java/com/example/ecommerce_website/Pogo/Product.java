package com.example.ecommerce_website.Pogo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = "id should be not null")
    @Min(value=3 ,message = " id have to be 3 character long")
    private int id ;

    @NotEmpty(message = "should be not empty")
    @Size(min=3 ,message = "name have to be 3 character long")
    private String name ;

    @NotNull(message = "should be not empty")
    @Positive(message = "must be positive number ")
    private int price;


    // forign key
   @NotEmpty(message = "should be not empty")
   @Size(min=3 ,message = "categoryID have to be 3 character long")
   private String categoryID;



}
