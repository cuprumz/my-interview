package com.cuprumz.pojo;

public class Hero {
    
    private Integer number;
    private String name;
    private String country;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
