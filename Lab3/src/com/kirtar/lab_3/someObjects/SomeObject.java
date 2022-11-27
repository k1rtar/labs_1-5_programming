package com.kirtar.lab_3.someObjects;

import com.kirtar.lab_3.someObjects.interfaces.Stateable;
import com.kirtar.lab_3.someObjects.interfaces.Locationable;
import com.kirtar.lab_3.someObjects.interfaces.Nameable;

import java.util.Objects;

public abstract class SomeObject implements Nameable,Stateable,Locationable
{
	private String name,state,location;

	public SomeObject(String name, String state, String location)
	{
		this.setName(name);
		this.setState(state);
		this.setLocation(location);
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public String getName()
	{
		return name;
	}
	public String getState()
	{
		return state;
	}
	public String getLocation()
	{
		return location;
	}

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        SomeObject someObject = (SomeObject) otherObject;

        return Objects.equals(name, someObject.name) 
        && Objects.equals(state, someObject.state)
        && Objects.equals(location, someObject.location);
    }

    @Override 
    public String toString()
    {
    	return String.format("SomeObject(name=%s,state=%s,location=%s)",name,state,location);
    }

    @Override
    public int hashCode()
    {
    	return Objects.hash(name,state,location);
    }

}