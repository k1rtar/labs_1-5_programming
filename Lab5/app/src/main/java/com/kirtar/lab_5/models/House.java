package com.kirtar.lab_5.models;

import com.fasterxml.jackson.annotation.JsonProperty; 

public class House {
    @JsonProperty("name")
    private String name; 
    @JsonProperty("year")
    private long year; 
    @JsonProperty("numberOfLifts")
    private Integer numberOfLifts; 

    public House()
    {
        super();
    }
    public House(String name,long year,Integer numberOfLifts)
    {
        this.name = name;
        this.year = year;
        this.numberOfLifts = numberOfLifts;
    }

    @Override
    public String toString()
    {
        return String.format("House name = %s, year = %d,numberOfLifts = %d",name,year,numberOfLifts);
    }

}