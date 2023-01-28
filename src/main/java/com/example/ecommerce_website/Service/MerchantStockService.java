package com.example.ecommerce_website.Service;


import com.example.ecommerce_website.Pogo.Merchant;
import com.example.ecommerce_website.Pogo.MerchantStock;
import com.example.ecommerce_website.Pogo.Product;
import com.example.ecommerce_website.Pogo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MerchantStockService {


    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    ArrayList<Product>products = new ArrayList<>();
    ArrayList<User>users = new ArrayList<>();

    public ArrayList<MerchantStock> GetAll() {
        return merchantStocks;
    }

    public void AddMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);
    }


    public boolean UpdateMerchant(int id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }


    public boolean DeleteMerchant(int id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }




}
