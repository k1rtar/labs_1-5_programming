package com.kirtar.lab_3.someObjects.characters;

import com.kirtar.lab_3.someObjects.SomeObject;

import java.util.Objects;

public class Policemen extends SomeObject
{
	public Policemen(String name,String state,String location)
	{
		super(name,state,location);
	}

	public String shoot(String gun,String target)
	{
		return this.toString()+"ñòðåëÿþò èç "+gun+" â "+target;
	}

	public String run()
	{
		return this.toString()+" áåãóò ";		
	}
	public String pounce(String target)
	{
		return this.toString().toString()+" íàáðîñèëèñü íà"+target;
	}
	public String destroy(String target)
	{
		return this.toString()+" óíè÷òîæàþò "+target;
	}
	public String climb()
	{
		return this.toString()+" ïîëåçëè ";
	}
	public String tumble()
	{
		return this.toString()+" êóâûðêàþòñÿ ";
	}
	public String wavingTheirArms()
	{
		return this.toString()+" ðàçìàõèâàþò ðóêàìè ";
	}

	public String kickYourFeet()
	{
		return this.toString()+" áðûêàþòñÿ íîãàìè ";
	}

	public String wagTheBody()
	{
		return this.toString()+" âèëÿþò òåëîì ";
	}

	public String collideWithEachOther()
	{
		return this.toString()+" ñòàëêèâàþòñÿ äðóã ñ äðóãîì ";
	}

	public String flyApart()
	{
		return this.toString()+" ðàçëåòàþòñÿ â ñòîðîíû ";
	}
	public String soarUp()
	{
		return this.toString()+" âçâèâàþòñÿ êâåðõó ";
	}
	public String fallDown()
	{
		return this.toString()+" ïàäàþò âíèç ";
	}

	public String pushOffTheGround()
	{
		return this.toString()+" îòòàëêèâàþòñÿ îò çåìëè ";
	}

	public String jump()
	{
		return this.toString()+" ïîäñêàêèâàþò ";
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
    	return 7*Objects.hash("Ïîëèöåéñêèå",this.getName(),this.getState(),this.getLocation());
    }	
}