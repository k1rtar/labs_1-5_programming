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
		return this.toString()+" ����������� "+what+" "+toWhom;
	}
	
	public String decide(String something)
	{
		return this.toString()+" ����� "+something;
	}
	public String see(String something)
	{
		return this.toString()+" ������ "+something;
	}
	public String observe(String something)
	{
		return this.toString()+" ������� "+something;
	}
	public String grab(String something,String how)
	{
		return this.toString()+" ������� "+something+how;
	}
	public String dragIn(String something, String where)
	{
		return this.toString()+" ������ "+something+where;
	}
	
	public String slamTheDoor(String how)
	{
		return this.toString()+" ��������� "+how+" �����";
	}
	
	public String hear(String something)
	{
		return this.toString()+" ������� "+something;
	}
	
	public String lookOutTheWindow()
	{
		return this.toString()+" ��������� � �����������";
	}
	
	public String said(String something)
	{
		return this.toString()+" ������ "+something;
	}
	
	public String goToBed()
	{
		return this.toString()+" �� ����� ";
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
    	return 229*Objects.hash("������",this.getName(),this.getState(),this.getLocation());
    }	
}