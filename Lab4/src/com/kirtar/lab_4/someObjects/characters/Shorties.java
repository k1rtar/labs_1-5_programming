package com.kirtar.lab_4.someObjects.characters;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class Shorties extends SomeObject
{
	public Shorties(String name,String state,String location)
	{
		super(name,state,location);
	}
	
	public String skip(String where,String whom)
	{
		return this.toString()+" ���������� "+where+" "+whom;
	}
	public String climbed(String how,String where)
	{
		return this.toString()+" ������� "+how+" "+where;
	}
	
	public String decide(String what)
	{
		return this.toString()+" ������ "+what;
	}
	public String sleep(String how)
	{
		return this.toString()+" ������� "+how;
	}
	
	public String startConstruction(String management)
	{
		return this.toString()+" ���������� � ������������� "+management;
	}
		
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        Shorties shorties = (Shorties) otherObject;

        return Objects.equals(this.getName(), shorties.getName()) 
        && Objects.equals(this.getState(), shorties.getState())
        && Objects.equals(this.getLocation(), shorties.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("Shorties(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 230*Objects.hash("���������",this.getName(),this.getState(),this.getLocation());
    }	
}