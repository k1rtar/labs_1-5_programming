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
		return this.toString()+"стреляют из "+gun+" в "+target;
	}

	public String run()
	{
		return this.toString()+" бегут ";		
	}
	public String pounce(String target)
	{
		return this.toString().toString()+" набросились на"+target;
	}
	public String destroy(String target)
	{
		return this.toString()+" уничтожают "+target;
	}
	public String climb()
	{
		return this.toString()+" полезли ";
	}
	public String tumble()
	{
		return this.toString()+" кувыркаются ";
	}
	public String wavingTheirArms()
	{
		return this.toString()+" размахивают руками ";
	}

	public String kickYourFeet()
	{
		return this.toString()+" брыкаются ногами ";
	}

	public String wagTheBody()
	{
		return this.toString()+" виляют телом ";
	}

	public String collideWithEachOther()
	{
		return this.toString()+" сталкиваются друг с другом ";
	}

	public String flyApart()
	{
		return this.toString()+" разлетаются в стороны ";
	}
	public String soarUp()
	{
		return this.toString()+" взвиваются кверху ";
	}
	public String fallDown()
	{
		return this.toString()+" падают вниз ";
	}

	public String pushOffTheGround()
	{
		return this.toString()+" отталкиваются от земли ";
	}

	public String jump()
	{
		return this.toString()+" подскакивают ";
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
    	return 7*Objects.hash("Полицейские",this.getName(),this.getState(),this.getLocation());
    }	
}