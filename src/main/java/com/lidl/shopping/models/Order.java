package com.lidl.shopping.models;

import javax.validation.constraints.NotNull;

public class Order {

    @NotNull
    private String name;
    
    private Integer id;
    
    public Order() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
