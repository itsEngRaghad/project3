package com.example.springproject2.Controller;

import com.example.springproject2.APIResponse.APIResponse;
import com.example.springproject2.Model.Merchant;
import com.example.springproject2.Model.Product;
import com.example.springproject2.Service.MerchantService;
import com.example.springproject2.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {

    // (1) making product service (object) to link w controller
    //any logic will go throu this obj to service
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        // we arrived to the method in service by the object here
        ArrayList<Merchant> merchants=merchantService.getMerchant();
        // in body we returned the array
        return ResponseEntity.status(200).body(merchants);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant has been added");
    }

    //update
    @PutMapping("/update/{merchantID}")

    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant, Errors errors, @PathVariable int merchantID){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        boolean isUpdate= merchantService.updateMerchant(merchantID,merchant);
        if (isUpdate){
            return ResponseEntity.status(200).body("merchant has been updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }


    //delete product
    @DeleteMapping("/delete/{merchantID}")
    public ResponseEntity deleteProduct(@PathVariable int merchantID ){
        boolean isDeleted= merchantService.deleteMerchant(merchantID);
        if(isDeleted){
            return ResponseEntity.status(200).body("merchant has been deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
}
