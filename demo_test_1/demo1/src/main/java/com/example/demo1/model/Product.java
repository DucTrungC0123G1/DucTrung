package com.example.demo1.model;

import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private Date nsx;
    private boolean typeProduct;
    private String description;

    public Product() {
    }

    public Product(int id, String name, Date nsx, boolean typeProduct, String description) {
        this.id = id;
        this.name = name;
        this.nsx = nsx;
        this.typeProduct = typeProduct;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNsx() {
        return nsx;
    }

    public void setNsx(Date nsx) {
        this.nsx = nsx;
    }

    public boolean isTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(boolean typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
