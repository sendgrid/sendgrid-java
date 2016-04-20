package com.sendgrid;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Email {
    @JsonProperty("name") private String name;
    @JsonProperty("email") private String email;
    
    public void setName(String name) {
        this.name = name;
    }
    
    @JsonProperty("name") 
    public String getName() {
        return name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @JsonProperty("email") 
    public String getEmail() {
        return email;
    }
}