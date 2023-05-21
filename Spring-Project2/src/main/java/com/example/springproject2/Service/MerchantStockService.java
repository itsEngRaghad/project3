package com.example.springproject2.Service;

import com.example.springproject2.Model.MerchantStock;
import com.example.springproject2.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();


    //get Array
    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
        //return the array
    }

    //add MerchantStock
    public void addMerchantStocks(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);
    }


    //updating MerchantStock if it's exist
    public boolean updateMerchantStock(int merchantID, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) { //for loop to search  p id inside the array
            if (merchantStocks.get(i).getId() == merchantID)
            {
                merchantStocks.set(i, merchantStock); //if found, update
                return true;
            }

        }
        return false;

    }


    //Delete MerchantStock if it's exist

    public boolean deleteMerchantStock(int merchantID){
        for (int i=0; i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==merchantID){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }
}
