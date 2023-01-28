package com.example.ecommerce_website.Controller;


import com.example.ecommerce_website.Pogo.Category;
import com.example.ecommerce_website.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("/get")
    public ResponseEntity GetCategory(){
        ArrayList<Category>categore = categoryService.GetAll();
        return ResponseEntity.status(200).body(categore);
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.AddCategory(category);
        return ResponseEntity.status(200).body("Category added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id , @Valid @RequestBody Category category , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean Isupdated = categoryService.UpdateCategory(id,category);
        if(Isupdated){
            return ResponseEntity.status(200).body("category updated");
        }
        else {
            return ResponseEntity.status(400).body("wrong id");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isdeleted = categoryService.DeleteCategory(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("category deleted");
        }
        else {
            return ResponseEntity.status(400).body("wrong id");
        }
    }

}
