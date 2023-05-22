package com.example.springproject2.Controller;

import com.example.springproject2.APIResponse.APIResponse;
import com.example.springproject2.Model.Product;
import com.example.springproject2.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


//Controller
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor //(2) to link the object w controller
public class ProductController {

    // (1) making product service (object) to link w controller
    //any logic will go throu this obj to service
   private final ProductService productService;

   @GetMapping("/get")
    public ResponseEntity getProduct(){
        // we arrived to the method in service by the object here
        ArrayList<Product> products=productService.getProducts();
        // in body we returned the array
        return ResponseEntity.status(200).body(products);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors){

       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new APIResponse(message));
       }
       productService.addProduct(product);
       return ResponseEntity.status(200).body("product has been added");
    }

    //update
    @PutMapping("/update/{productID}")

    public ResponseEntity updateProduct(@Valid @RequestBody Product product, Errors errors, @PathVariable int productID){

       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new APIResponse(message));
       }
       boolean isUpdate= productService.updateProduct(productID,product);
       if (isUpdate){
           return ResponseEntity.status(200).body("product has been updated");
       }
       return ResponseEntity.status(400).body("wrong id");
    }


    //delete product
    @DeleteMapping("/delete/{productID}")
    public ResponseEntity deleteProduct(@PathVariable int productID ){
       boolean isDeleted= productService.deleteProduct(productID);
       if(isDeleted){
           return ResponseEntity.status(200).body("product has been deleted");
       }
       return ResponseEntity.status(400).body("wrong id");
    }

}
