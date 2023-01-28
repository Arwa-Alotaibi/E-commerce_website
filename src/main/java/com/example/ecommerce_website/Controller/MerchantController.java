package com.example.ecommerce_website.Controller;


import com.example.ecommerce_website.Pogo.Merchant;
import com.example.ecommerce_website.Service.MerchantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import org.springframework.validation.Errors;
@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    MerchantService merchantService;
    public MerchantController(MerchantService merchantService){
        this.merchantService =merchantService;
    }


    @GetMapping("/get")
    public ResponseEntity GetALL(){
        ArrayList<Merchant> merchants = merchantService.GetAll();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity AddMerchant(@Valid @RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.AddMerchant(merchant);
        return ResponseEntity.status(200).body("merchant added");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateMerchant(@PathVariable  int id ,@Valid @RequestBody Merchant merchant, Errors errors ){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean IsUpdated = merchantService.UpdateMerchant(id,merchant);
        if(IsUpdated){
            return ResponseEntity.status(200).body("merchant updated");
        }
        else {
            return ResponseEntity.status(400).body("wrong id!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity Delete(@PathVariable int id){
        boolean isdeleted = merchantService.DeleteMerchant(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("merchant deleted");
        }
        else {
            return ResponseEntity.status(400).body("wrong id");

        }
    }

}
