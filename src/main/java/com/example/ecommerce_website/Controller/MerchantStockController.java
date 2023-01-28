package com.example.ecommerce_website.Controller;

import com.example.ecommerce_website.Pogo.MerchantStock;
import com.example.ecommerce_website.Pogo.User;
import com.example.ecommerce_website.Service.MerchantStockService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantstock")
public class MerchantStockController {
    MerchantStockService merchantStockService;
    public MerchantStockController( MerchantStockService merchantStockService){
        this.merchantStockService = merchantStockService;
    }

    @GetMapping("/get")
    public ResponseEntity Get(){
        ArrayList<MerchantStock> merchantStock = merchantStockService.GetAll();
        return ResponseEntity.status(200).body(merchantStock);
    }

   @PostMapping("/add")
    public  ResponseEntity AddMerchantStock(@Valid @RequestBody MerchantStock merchantStocks , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.AddMerchantStock(merchantStocks);
       return ResponseEntity.status(200).body("merchantStocks added");
   }


   @PutMapping("/edit/{id}")
    public ResponseEntity EditMerchantStock(@PathVariable int id ,@Valid @RequestBody MerchantStock merchantStocks , Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean IsUpdated = merchantStockService.UpdateMerchant(id,merchantStocks);
        if(IsUpdated){
            return ResponseEntity.status(200).body("updated");
        }
        else {
            return ResponseEntity.status(400).body("wrong id");

        }
   }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteMerchantStock(@PathVariable int id){
        boolean IsDeleted = merchantStockService.DeleteMerchant(id);
        if(IsDeleted){
            return ResponseEntity.status(200).body("deleted");
        }
        else {
            return ResponseEntity.status(400).body("wrong id ");

        }
   }

}
