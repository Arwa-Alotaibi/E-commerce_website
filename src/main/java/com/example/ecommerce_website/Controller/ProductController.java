package com.example.ecommerce_website.Controller;


import com.example.ecommerce_website.Pogo.Product;
import com.example.ecommerce_website.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import org.springframework.validation.Errors;
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/get")
    public ResponseEntity GetProduct(){
        ArrayList<Product> product = productService.getProducts();
        return ResponseEntity.status(200).body(product);
    }

    @PostMapping("/add")
    public ResponseEntity AddProduct(@Valid @RequestBody Product product , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.AddProduct(product);
        return ResponseEntity.status(200).body("product added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity UpdateProduct(@PathVariable int id , @Valid @RequestBody Product product , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean updated = productService.UpdateProduct(id,product);
        if(updated){
            return ResponseEntity.status(200).body("product updated");
        }
        else{
            return ResponseEntity.status(400).body("wrong id !");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity RemoveProduct(@PathVariable int id){
        boolean isdeleted = productService.RemoveProduct(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("deleted");
        }
        else {
            return ResponseEntity.status(400).body("wrong id");
        }
    }
}
