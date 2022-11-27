package com.kirtar.lab_3.someObjects.characters;

import com.kirtar.lab_3.someObjects.SomeObject;
import com.kirtar.lab_3.someObjects.enums.Appliance;

import java.util.Objects;

public class Somebody extends SomeObject
{
	public Somebody(String name,String state,String location)
	{
		super(name,state,location);
	}
	
	public void turnOnTheWeightlessnessDevice(SomeObject p)
	{
		Appliance a = Appliance.WEIGHTLESSNESSDEVICE;
		System.out.print(this.getName()+" включил прибор невесомости. ");
		a.action("вкл",p);
	}
	
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        Somebody somebody = (Somebody) otherObject;

        return Objects.equals(this.getName(), somebody.getName()) 
        && Objects.equals(this.getState(), somebody.getState())
        && Objects.equals(this.getLocation(), somebody.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("Somebody(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 5*Objects.hash("Кто-то",this.getName(),this.getState(),this.getLocation());
    }	
}