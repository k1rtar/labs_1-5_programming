package com.kirtar.lab_4.someObjects.characters;

import com.kirtar.lab_4.someObjects.SomeObject;

import java.util.Objects;

public class Policemen extends SomeObject
{
	public Policemen(String name,String state,String location)
	{
		super(name,state,location);
	}

	public String shoot(String gun,String target)
	{
		return this.toString()+"�������� �� "+gun+" � "+target;
	}

	public String run()
	{
		return this.toString()+" ����� ";		
	}
	public String pounce(String target)
	{
		return this.toString().toString()+" ����������� ��"+target;
	}
	public String destroy(String target)
	{
		return this.toString()+" ���������� "+target;
	}
	public String climb()
	{
		return this.toString()+" ������� ";
	}
	public String tumble()
	{
		return this.toString()+" ����������� ";
	}
	public String wavingTheirArms()
	{
		return this.toString()+" ����������� ������ ";
	}

	public String kickYourFeet()
	{
		return this.toString()+" ��������� ������ ";
	}

	public String wagTheBody()
	{
		return this.toString()+" ������ ����� ";
	}

	public String collideWithEachOther()
	{
		return this.toString()+" ������������ ���� � ������ ";
	}

	public String flyApart()
	{
		return this.toString()+" ����������� � ������� ";
	}
	public String soarUp()
	{
		return this.toString()+" ���������� ������ ";
	}
	public String fallDown()
	{
		return this.toString()+" ������ ���� ";
	}

	public String pushOffTheGround()
	{
		return this.toString()+" ������������� �� ����� ";
	}

	public String jump()
	{
		return this.toString()+" ������������ ";
	}

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null 
        	|| getClass() != otherObject.getClass() 
        	|| !super.equals(otherObject)) return false;

        Policemen policemen = (Policemen) otherObject;

        return Objects.equals(this.getName(), policemen.getName()) 
        && Objects.equals(this.getState(), policemen.getState())
        && Objects.equals(this.getLocation(), policemen.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("Policemen(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 7*Objects.hash("�����������",this.getName(),this.getState(),this.getLocation());
    }	
}