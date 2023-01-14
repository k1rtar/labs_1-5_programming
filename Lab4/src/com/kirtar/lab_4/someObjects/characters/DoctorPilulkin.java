package com.kirtar.lab_4.someObjects.characters;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class DoctorPilulkin extends SomeObject
{
	
	public DoctorPilulkin(String name,String state,String location)
	{
		super(name,state,location);
	}
	
	public String saw(String something)
	{
		return this.toString()+" увидел "+something;
	}
	
	public String rush(String target,String attributes)
	{
		return this.toString()+" бросился к"+target+" с "+attributes;
	}
	
	public String examineTheWound(String conclusion)
	{
		return this.toString()+" осмотрел рану "+conclusion;
	}
	public String stopTheBleeding(String how)
	{
		return this.toString()+how+" остановил кровотечение ";
	}
	
	public String bandage(String where)
	{
		return this.toString()+" наложил "+where+" повязку "; 
	}
	public String sleep()
	{
		return this.toString()+" лёг спать ";
	}
	
	
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        DoctorPilulkin doctorPilulkin = (DoctorPilulkin) otherObject;

        return Objects.equals(this.getName(), doctorPilulkin.getName()) 
        && Objects.equals(this.getState(), doctorPilulkin.getState())
        && Objects.equals(this.getLocation(), doctorPilulkin.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("DoctorPilulkin(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 240*Objects.hash("Доктор Пилюлкин",this.getName(),this.getState(),this.getLocation());
    }	
}