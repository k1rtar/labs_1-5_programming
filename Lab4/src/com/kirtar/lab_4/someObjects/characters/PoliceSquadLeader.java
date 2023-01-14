package com.kirtar.lab_4.someObjects.characters;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class PoliceSquadLeader extends SomeObject
{
	public PoliceSquadLeader(String name,String state,String location)
	{
		super(name,state,location);
	}
	
	public String scream(String text)
	{
		return this.toString()+" �������� "+text;
	}
	public String putHandsToMouth(String how)
	{
		return this.toString()+" �������� �� ��� ���� "+how;
	}
	public String makeSure(String what)
	{
		return this.toString()+" �������� "+what;
	}
	public String wave(String something)
	{
		return this.toString()+" �������� "+something;
	}
	
	
	
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        PoliceSquadLeader policeSquadLeader = (PoliceSquadLeader) otherObject;

        return Objects.equals(this.getName(), policeSquadLeader.getName()) 
        && Objects.equals(this.getState(), policeSquadLeader.getState())
        && Objects.equals(this.getLocation(), policeSquadLeader.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("PoliceSquadLeader(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 228*Objects.hash("�������� ������������ ������",this.getName(),this.getState(),this.getLocation());
    }	
}