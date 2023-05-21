package com.example.springproject2.Service;

import com.example.springproject2.Model.Category;
import com.example.springproject2.Model.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class CategoryService {

    //Array
    ArrayList<Category> categories = new ArrayList<>();


    //get Array
    public ArrayList<Category> getCategory() {
        return categories;
        //return the array
    }

    //add category
    public void addCategory(Category category) {
        categories.add(category);
    }


    //updating category if it's exist
    public boolean updateCategory(int categoryID, Category category) {
        for (int i = 0; i < categories.size(); i++) { //for loop to search  p id inside the array
            if (categories.get(i).getId() == categoryID)
            {
                categories.set(i, category); //if found, update
                return true;
            }

        }
        return false;

    }


    //Delete product if it's exist

    public boolean deleteCategory(int categoryID){
        for (int i=0; i<categories.size();i++){
            if(categories.get(i).getId()==categoryID){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

}
