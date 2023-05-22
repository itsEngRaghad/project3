package com.example.springproject2.Service;

import com.example.springproject2.Model.Product;
import com.example.springproject2.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();


    //get Array
    public ArrayList<User> getUsers() {
        return users;
        //return the array
    }

    //add user
    public void addUser(User user) {
        users.add(user);
    }


    //updating user if it's exist
    public boolean updateUser(int userID, User user) {
        for (int i = 0; i < users.size(); i++) { //for loop to search  p id inside the array
            if (users.get(i).getId() == userID)
            {
                users.set(i, user); //if found, update
                return true;
            }

        }
        return false;

    }


    //Delete user if it's exist

    public boolean deleteUser(int userID){
        for (int i=0; i<users.size();i++){
            if(users.get(i).getId()==userID){
                users.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean buyProduct(int userID, int merchantID,int productID) {
        for (int i = 0; i < users.size(); i++) { //for loop to search  p id inside the array
            if (users.get(i).getId() == userID)
            {
                if (users.get(i).getId() == merchantID)
                {
                    if (users.get(i).getId() == productID)
                    {
                        return true;
                    }
                    return true;
                }
                return true;
            }

        }
        return false;

    }


}
