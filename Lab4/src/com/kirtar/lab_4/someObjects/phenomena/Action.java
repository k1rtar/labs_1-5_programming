package com.kirtar.lab_4.someObjects.phenomena;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class Action extends SomeObject
{
	public Action(String name,String state,String location)
	{
		super(name,state,location);
	}
	
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        Action action = (Action) otherObject;

        return Objects.equals(this.getName(), action.getName()) 
        && Objects.equals(this.getState(), action.getState())
        && Objects.equals(this.getLocation(), action.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("Action(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 256*Objects.hash("Действие",this.getName(),this.getState(),this.getLocation());
    }	
}