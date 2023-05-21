package com.example.springproject2.Controller;

import com.example.springproject2.APIResponse.APIResponse;
import com.example.springproject2.Model.Category;
import com.example.springproject2.Model.Product;
import com.example.springproject2.Service.CategoryService;
import com.example.springproject2.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
    @RequestMapping("/api/v1/category")
   @RequiredArgsConstructor
public class CategoryController {

    //creat an object
    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategory(){
        // we arrived to the method in service by the object here
        ArrayList<Category> categories=categoryService.getCategory();
        // in body we returned the array
        return ResponseEntity.status(200).body(categories);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        categoryService.addCategory(category);//weird
        return ResponseEntity.status(200).body("category has been added");
    }

    //update
    @PutMapping("/update/{categoryID}")

    public ResponseEntity updateCategory(@Valid @RequestBody Category category, Errors errors, @PathVariable int categoryID){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        boolean isUpdate= categoryService.updateCategory(categoryID,category);
        if (isUpdate){
            return ResponseEntity.status(200).body("category has been updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }


    //delete product
    @DeleteMapping("/delete/{categoryID}")
    public ResponseEntity deleteCategory(@PathVariable int categoryID ){
        boolean isDeleted= categoryService.deleteCategory(categoryID);
        if(isDeleted){
            return ResponseEntity.status(200).body("category has been deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

}
