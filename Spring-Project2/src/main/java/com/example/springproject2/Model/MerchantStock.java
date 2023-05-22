package com.example.springproject2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MerchantStock {

    //id ( must not be empty , have to be 3 character long ).
    //productid ( must not be empty , have to be 3 character long ).
    //merchantid ( must not be empty , have to be 3 length long ).
    //stock ( must not be empty , have to be more than 10 at start ).

    @NotNull(message = "id can not be null")
    @Min(value = 3,message = "it has to be at least 3 digits")
    private int id;

    @NotNull(message = "id can not be null")
    @Min(value = 3,message = "it has to be at least 3 digits")
    private int productID;

    @NotNull(message = "id can not be null")
    @Min(value = 3,message = "it has to be at least 3 digits")
    private int merchantID;
    @NotNull(message = "stock can not be null")
    @Min(value = 11,message = "it has to be more than 10 digits")
    private int stock;



}
