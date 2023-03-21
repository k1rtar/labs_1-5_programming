package com.kirtar.lab_5.models;
import com.fasterxml.jackson.annotation.JsonProperty;  

public class Coordinates {
    @JsonProperty("x")
    private int x; //Значение поля должно быть больше -232
    @JsonProperty("y")
    private float y; //Значение поля должно быть больше -150
    public Coordinates()
    {
        super();
    }
    public Coordinates(int x, float y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public float getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(float y)
    {
        this.y = y;
    }
    @Override 
    public String toString()
    {
    	return String.format("(x=%d,y=%f)",x,y);
    }   
    
}