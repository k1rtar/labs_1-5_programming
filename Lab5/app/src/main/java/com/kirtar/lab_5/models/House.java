package com.kirtar.lab_5.models;

import com.fasterxml.jackson.annotation.JsonProperty; 

public class House {
    @JsonProperty("name")
    private String name; //Поле может быть null
    @JsonProperty("year")
    private long year; //Значение поля должно быть больше 0
    @JsonProperty("numberOfLifts")
    private Integer numberOfLifts; //Значение поля должно быть больше 0

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
}