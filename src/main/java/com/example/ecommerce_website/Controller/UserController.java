package com.example.ecommerce_website.Controller;

import com.example.ecommerce_website.Pogo.MerchantStock;
import com.example.ecommerce_website.Pogo.Product;
import com.example.ecommerce_website.Service.MerchantStockService;
import com.example.ecommerce_website.Service.ProductService;
import com.example.ecommerce_website.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerce_website.Pogo.MerchantStock;

import java.util.ArrayList;
import com.example.ecommerce_website.Pogo.User;
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    UserService userService;
    MerchantStockService merchantStockService;

    ProductService productService;

    public UserController(UserService userService ,MerchantStockService merchantStockService ,ProductService productService){
        this.userService = userService;
        this.merchantStockService = merchantStockService;
        this.productService = productService;
    }


    @GetMapping("/get")
    public ResponseEntity GetAll(){
        ArrayList<User> user =userService.GetUsers();
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/add")
    public ResponseEntity AddUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.AddUsers(user);
        return ResponseEntity.status(200).body("user added !");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity EditUser(@PathVariable int id ,@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = userService.EditUser(id,user);
        if(isupdated){
            return ResponseEntity.status(200).body("user updated");
        }
        else {
            return ResponseEntity.status(400).body("wrong id");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteUser(@PathVariable int id){
        boolean isdeleted = userService.DeleteUser(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("user deleted");
        }
        else {
            return ResponseEntity.status(400).body("wrong id");
        }
    }

    @PutMapping("/product/{productid}/{merchantid}/{stock}")
    public ResponseEntity Addproduct(@PathVariable int productid , @PathVariable int merchantid  , @PathVariable int stock ,@Valid @RequestBody User user ,@RequestBody Product product ,Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean add =userService.AddProduct(productid ,  merchantid ,  stock,product);
        if(add){
            return ResponseEntity.status(200).body("user added product to a merchantStock :) !");
        }
        else {
            return ResponseEntity.status(400).body("user not added product check for id  !");
        }
    }
    @PutMapping("/buy/{id}/{productid}/{merchantid}")
    public ResponseEntity BuyProduct(@PathVariable int id ,@PathVariable int productid , @PathVariable int merchantid) {
        int check=userService.BuyProduct(id,productid,merchantid);
        if(check==10){
            return ResponseEntity.status(400).body("the stock has no product");
        }
       else if(check==1){
            return ResponseEntity.status(200).body("user can buy");
        }

       else {
            return ResponseEntity.status(400).body("user cant buy");

        }

    }


}
