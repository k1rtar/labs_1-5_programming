package com.kirtar.lab_4.someObjects.phenomena;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class TimeOfDay extends SomeObject
{
	public TimeOfDay(String name)
	{
		super(name,"","");
	}
	
	public String comes()
	{
		return " Наступает "+this.toString();	

	}
	public String ended()
	{
		return " Завершается "+this.toString();
	}
	
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        TimeOfDay timeOfDay = (TimeOfDay) otherObject;

        return Objects.equals(this.getName(), timeOfDay.getName()) 
        && Objects.equals(this.getState(), timeOfDay.getState())
        && Objects.equals(this.getLocation(), timeOfDay.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("TimeOfDay(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 251*Objects.hash("Время суток",this.getName(),this.getState(),this.getLocation());
    }	
}