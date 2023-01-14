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
		return this.toString()+" ������ "+something;
	}
	
	public String rush(String target,String attributes)
	{
		return this.toString()+" �������� �"+target+" � "+attributes;
	}
	
	public String examineTheWound(String conclusion)
	{
		return this.toString()+" �������� ���� "+conclusion;
	}
	public String stopTheBleeding(String how)
	{
		return this.toString()+how+" ��������� ������������ ";
	}
	
	public String bandage(String where)
	{
		return this.toString()+" ������� "+where+" ������� "; 
	}
	public String sleep()
	{
		return this.toString()+" �� ����� ";
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
    	return 240*Objects.hash("������ ��������",this.getName(),this.getState(),this.getLocation());
    }	
}