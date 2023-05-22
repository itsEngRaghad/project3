package com.example.springproject2.Service;

import com.example.springproject2.Model.Merchant;
import com.example.springproject2.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();


    //get Array
    public ArrayList<Merchant> getMerchant() {
        return merchants;
        //return the array
    }

    //add product
    public void addMerchant(Merchant merchant) {
        merchants.add(merchant);
    }


    //updating merchant if it's exist
    public boolean updateMerchant(int merchantID, Merchant merchant) {
        for (int i = 0; i < merchants.size(); i++) { //for loop to search  p id inside the array
            if (merchants.get(i).getId() == merchantID)
            {
                merchants.set(i, merchant); //if found, update
                return true;
            }

        }
        return false;

    }


    //Delete product if it's exist

    public boolean deleteMerchant(int merchantID){
        for (int i=0; i<merchants.size();i++){
            if(merchants.get(i).getId()==merchantID){
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }



}
