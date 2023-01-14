package com.kirtar.lab_4.someObjects.characters;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class Cameraman extends SomeObject
{
	public Cameraman(String name,String state,String location)
	{
		super(name,state,location);
	}
	
	public String flyOut(String where)
	{
		return this.toString()+" вылетел "+where;
	}
	
	public String tumble()
	{
		return this.toString()+" кувыркается ";
	}
	
	public String clingTo(String how, String foR)
	{
		return this.toString()+" уцепился руками "+foR;
	}
	
 
	
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        Cameraman cameraman = (Cameraman) otherObject;

        return Objects.equals(this.getName(), cameraman.getName()) 
        && Objects.equals(this.getState(), cameraman.getState())
        && Objects.equals(this.getLocation(), cameraman.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("Cameraman(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 245*Objects.hash("Телеоператор",this.getName(),this.getState(),this.getLocation());
    }	
}