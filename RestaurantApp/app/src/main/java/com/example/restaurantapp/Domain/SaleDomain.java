package com.example.restaurantapp.Domain;

public class SaleDomain {
    private String pic;
    private String name;
    private Double fee;
    private int sale;
    private String description;
    private String country;

    public SaleDomain(String pic, String name, Double fee, int sale, String description, String country) {
        this.pic = pic;
        this.name = name;
        this.fee = fee;
        this.sale = sale;
        this.description = description;
        this.country = country;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
