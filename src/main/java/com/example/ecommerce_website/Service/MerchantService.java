package com.example.ecommerce_website.Service;


import com.example.ecommerce_website.Pogo.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> GetAll(){
        return merchants;
    }

    public void AddMerchant(Merchant merchant){
        merchants.add(merchant);
    }

    public boolean UpdateMerchant(int id ,Merchant merchant){
        for(int i=0 ; i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }

    public boolean DeleteMerchant(int id){
        for(int i =0 ;i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }


}
