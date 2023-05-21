package com.example.springproject2.Controller;

import com.example.springproject2.APIResponse.APIResponse;
import com.example.springproject2.Model.Product;
import com.example.springproject2.Model.User;
import com.example.springproject2.Service.ProductService;
import com.example.springproject2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        // we arrived to the method in service by the object here
        ArrayList<User> users=userService.getUsers();
        // in body we returned the array
        return ResponseEntity.status(200).body(users);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user has been added");
    }

    //update
    @PutMapping("/update/{userID}")

    public ResponseEntity updateUser(@Valid @RequestBody User user, Errors errors, @PathVariable int userID){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        boolean isUpdate= userService.updateUser(userID,user);
        if (isUpdate){
            return ResponseEntity.status(200).body("user has been updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }


    //delete product
    @DeleteMapping("/delete/{userID}")
    public ResponseEntity deleteUser(@PathVariable int userID ){
        boolean isDeleted= userService.deleteUser(userID);
        if(isDeleted){
            return ResponseEntity.status(200).body("user has been deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
}
