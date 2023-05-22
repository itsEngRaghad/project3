package com.example.springproject2.Service;

import com.example.springproject2.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//Service
@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();


    //get Array
    public ArrayList<Product> getProducts() {
        return products;
        //return the array
    }

    //add product
    public void addProduct(Product product) {
        products.add(product);
    }


    //updating product if it's exist
    public boolean updateProduct(int productID, Product product) {
        for (int i = 0; i < products.size(); i++) { //for loop to search  p id inside the array
            if (products.get(i).getId() == productID)
            {
                products.set(i, product); //if found, update
                return true;
            }

        }
        return false;

    }


    //Delete product if it's exist

    public boolean deleteProduct(int productID){
        for (int i=0; i<products.size();i++){
            if(products.get(i).getId()==productID){
                products.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean checkProductId(int id){
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId() == id)
                return true;
        }
        return false;
    }

}
