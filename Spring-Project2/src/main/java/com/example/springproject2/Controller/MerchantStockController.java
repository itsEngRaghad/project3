package com.example.springproject2.Controller;

import com.example.springproject2.APIResponse.APIResponse;
import com.example.springproject2.Model.MerchantStock;
import com.example.springproject2.Model.Product;
import com.example.springproject2.Service.MerchantStockService;
import com.example.springproject2.Service.ProductService;
import com.example.springproject2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;
    private final MerchantController merchantController;
    private final ProductController productController;

    /// making obj for the endpoint
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        // we arrived to the method in service by the object here
        ArrayList<MerchantStock> merchantStocks=merchantStockService.getMerchantStocks();
        // in body we returned the array
        return ResponseEntity.status(200).body(merchantStocks);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        merchantStockService.addMerchantStocks(merchantStock);
        return ResponseEntity.status(200).body("MerchantStock has been added");
    }

    //update
    @PutMapping("/update/{MerchantStockID}")

    public ResponseEntity updateMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors, @PathVariable int MerchantStockID){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        boolean isUpdate= merchantStockService.updateMerchantStock(MerchantStockID,merchantStock);
        if (isUpdate){
            return ResponseEntity.status(200).body("MerchantStock has been updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }


    //delete product
    @DeleteMapping("/delete/{MerchantStockID}")
    public ResponseEntity deleteProduct(@PathVariable int MerchantStockID ){
        boolean isDeleted= merchantStockService.deleteMerchantStock(MerchantStockID);
        if(isDeleted){
            return ResponseEntity.status(200).body("MerchantStock has been deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }



    @PutMapping("/addproduct/{productID}/{merchantID}/{stock}")
    public ResponseEntity addProductToMerchantStock(@PathVariable int productID,@PathVariable int merchantID,@PathVariable int stock) {
        if (merchantController.getMerchantService().checkMerchantId(merchantID) && productController.getProduct().checkProductId(productID)) {
            boolean isFound = merchantStockService.addProductToMerchantStock(merchantID,productID,stock);
            if (isFound) {
                return ResponseEntity.status(200).body("Product has been added");
            }
            return ResponseEntity.status(400).body(" wrong id");
        }
        return ResponseEntity.status(400).body(" wrong id");
    }



}
