package com.example.springproject2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {

    //id ( must not be empty , have to be 3 character long ).
    //username ( must not be empty , have to be 5 length long ).
    //password ( must not be empty , have to be 6 length long , must have characters and digits ).
    //email ( must not be empty , must be valid email ).
    //role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
    //balance ( must not be empty , have to be positive ).

    @NotNull
//    @Size(min = 3,max = 3,message = "id has to be 3 digits")
    private int id;

    @NotEmpty(message = "username shouldn't be empty")
    @Size(min = 5,max = 5,message = "username has to be 5 characters")
    private String username;

    @NotEmpty
//    @Size(min = 6,max = 6,message = "password has to be at least 6 digits")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,6}$")
    //  ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,10}$
    //Password must contain at least one digit [0-9].
    //Password must contain at least one lowercase Latin character [a-z].
    //Password must contain at least one uppercase Latin character [A-Z].
    //Password must contain at least one special character like ! @ # & ( ).
    //Password must contain a length of at least 6 characters and a maximum of 10 characters.
    private String password;

    @NotEmpty(message = "email should not be empty")
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$",message = "email should be valid")
    private String email;

    @NotNull(message = "balance should not be empty")
    @Positive(message = "balance should be positive")
    private int balance;

    @NotEmpty(message = "Role SHOULDN'T BE Empty")
    @Pattern(regexp = "^(Admin|Customer)$", message = "Role field allow input: Admin or Customer only")
    //role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
    private String role;}
