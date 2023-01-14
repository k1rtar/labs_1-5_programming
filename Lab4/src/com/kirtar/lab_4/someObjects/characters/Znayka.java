package com.kirtar.lab_4.someObjects.characters;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class Znayka extends SomeObject
{
	public Znayka(String name,String state,String location)
	{
		super(name,state,location);
	}
	
	public String command(String what,String toWhom)
	{
		return this.toString()+" скомандовал "+what+" "+toWhom;
	}
	
	public String decide(String something)
	{
		return this.toString()+" решил "+something;
	}
	public String see(String something)
	{
		return this.toString()+" увидел "+something;
	}
	public String observe(String something)
	{
		return this.toString()+" заметил "+something;
	}
	public String grab(String something,String how)
	{
		return this.toString()+" схватил "+something+how;
	}
	public String dragIn(String something, String where)
	{
		return this.toString()+" втащил "+something+where;
	}
	
	public String slamTheDoor(String how)
	{
		return this.toString()+" захлопнул "+how+" дверь";
	}
	
	public String hear(String something)
	{
		return this.toString()+" услышал "+something;
	}
	
	public String lookOutTheWindow()
	{
		return this.toString()+" посмотрел в иллюминатор";
	}
	
	public String said(String something)
	{
		return this.toString()+" сказал "+something;
	}
	
	public String goToBed()
	{
		return this.toString()+" лёг спать ";
	}

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        Znayka znayka = (Znayka) otherObject;

        return Objects.equals(this.getName(), znayka.getName()) 
        && Objects.equals(this.getState(), znayka.getState())
        && Objects.equals(this.getLocation(), znayka.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("Znayka(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 229*Objects.hash("Знайка",this.getName(),this.getState(),this.getLocation());
    }	
}