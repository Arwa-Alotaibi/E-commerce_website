package com.example.ecommerce_website.Service;

import com.example.ecommerce_website.Pogo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import com.example.ecommerce_website.Pogo.User;
import com.example.ecommerce_website.Pogo.Merchant;
import com.example.ecommerce_website.Pogo.MerchantStock;
@Service
public class UserService {
    ArrayList<User> users = new ArrayList<User>();

    private MerchantStockService merchantStockService;
    private ProductService productService;
    public UserService(MerchantStockService merchantStockService ,ProductService productService){
        this.merchantStockService = merchantStockService;
        this.productService = productService;
    }


    public ArrayList<User> GetUsers(){
        return users;
    }

    public void AddUsers(User user){
        users.add(user);
    }


    public boolean EditUser(int id , User user){
        for(int i =0 ; i<users.size();i++){
            if(users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean DeleteUser(int id){
        for (int i=0 ; i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    ////Create endpoint where user can add product to a merchantStock
    public boolean AddProduct(int productid , int merchantid , int stock ,Product product) {
        ArrayList<MerchantStock> merchantStocks = merchantStockService.GetAll();
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getProductid() == productid && merchantStocks.get(i).getMerchantid() == merchantid) {
                int new_stok = merchantStocks.get(i).getStock()+stock;
                merchantStocks.get(i).setStock(stock);
                return true;
            }
        }
        return false;

    }
    //Create endpoint where user can buy a product directly
//this endpoint should accept userid , product id , merchantid.

    public int BuyProduct(int id , int productid , int merchantid){
        ArrayList<MerchantStock> merchantStocks = merchantStockService.GetAll();
        ArrayList<Product> products = productService.getProducts();
        for(int u=0 ; u<users.size();u++){
            for(int m=0 ;m<merchantStocks.size();m++){
              if(users.get(u).getId()==id && merchantStocks.get(m).getProductid()==productid && merchantStocks.get(m).getMerchantid()==merchantid){
                  if(merchantStocks.get(m).getStock()==10){
                      return 10;
                  }
                  else {
                      int reduce = merchantStocks.get(m).getStock()-1;
                      merchantStocks.get(m).setStock(reduce);
                      for(int p=0 ;p<products.size();p++){
                          int deducted =  users.get(u).getBalance()-products.get(p).getPrice() ;
                          if(products.get(p).getPrice()<users.get(u).getBalance()){
                              users.get(u).setBalance(deducted);
                              return 1;
                          }
                          else{
                              return -1;
                          }
                      }
                      }

                  }
              }
            }
        return 0;
    }

}
