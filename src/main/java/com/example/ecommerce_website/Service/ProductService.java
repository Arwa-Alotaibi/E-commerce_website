package com.example.ecommerce_website.Service;


import com.example.ecommerce_website.Pogo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void AddProduct(Product product){

        products.add(product);
    }
    public boolean UpdateProduct(int id , Product product){
        for (int i=0 ; i<products.size();i++){
            if(products.get(i).getId()==id){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }

    public boolean RemoveProduct(int id){
        for(int i=0 ;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.remove(i);
                return true;
            }
        }
        return false;

    }
}
