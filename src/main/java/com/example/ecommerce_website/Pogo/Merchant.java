package com.example.ecommerce_website.Pogo;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {

    @NotNull(message = "the id should be not null")
    @Min(value = 3 ,message=" id have to be 3 character long")
    private int id ;


    @NotEmpty(message = "the name must be not empty")
    @Size(min = 3 , message = "name have to be 3 length long")
    private String name;


}
