package com.example.ecommerce_website.Service;

import com.example.ecommerce_website.Pogo.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories =new ArrayList<>();

    public ArrayList<Category> GetAll(){
        return categories;
    }
    public void AddCategory(Category category){
        categories.add(category);
    }

    public boolean UpdateCategory(int id ,Category category){
        for(int i=0 ;i<categories.size();i++){
            if(categories.get(i).getId()==id){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }
    public  boolean DeleteCategory(int id){
        for (int i=0 ; i<categories.size();i++){
            if(categories.get(i).getId()==id){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }


}

