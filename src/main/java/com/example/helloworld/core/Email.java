package com.example.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


public class Email {

    @Length(max = 100)
    private String email;


    public Email() {
        // Jackson deserialization
    }

     @JsonProperty
     public String getEmail() {
         return email;
     }



}
