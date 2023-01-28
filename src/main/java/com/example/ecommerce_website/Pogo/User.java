package com.example.ecommerce_website.Pogo;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class User {


    @NotNull(message = "the id must be notnull")
    @Min(value = 3 ,message =" id have to be 3 character long" )
    private int id ;


    @NotEmpty(message = "the name must be not empty")
    @Size(min=5 , message = "have to be 5 length long ")
    private String username;

    @NotEmpty(message = "the password should be not empty")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d]{6,}")
    private String password;


    @NotEmpty(message = "the email should be not empty")
    @Email(message = "must be a valid email")
    private String email;

    @NotEmpty(message = "the role should be not empty")
    @Pattern(regexp = "Admin|Customer")
    private String role;


    @NotNull(message = "the balance should be not empty")
    @Positive(message = "should be a positive balance")
    private int balance ;

}
