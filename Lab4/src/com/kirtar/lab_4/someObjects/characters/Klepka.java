package com.kirtar.lab_4.someObjects.characters;

import com.kirtar.lab_4.someObjects.SomeObject;


import java.util.Objects;

public class Klepka extends SomeObject
{
	public Klepka(String name,String state,String location)
	{
		super(name,state,location);
	}
	
	public static class WhiteShirt
	{
		public static String becomeBloody()
			{
				return " на белом рукаве рубашки появилось красное расплывающееся пятно крови ";
			}
	}	
	
	public String beInjured(String cause)
	{
		class Face
		{
			public String distort(String cause)
			{
				return "Лицо Клёпки исказилось "+cause;
			}
		}

		Face face = new Face();
		
		return face.distort(cause)+Klepka.WhiteShirt.becomeBloody();
		
	}	
	
	public String turnOut(String where)
	{
		return this.toString()+" оказался "+where;
	}
	
	public String feel(String something)
	{
		return this.toString()+" почувствовал "+something;
	}
		
	public String bearThePain(String how)
	{
		return this.toString()+how+" терпит боль ";
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

        Klepka klepka = (Klepka) otherObject;

        return Objects.equals(this.getName(), klepka.getName()) 
        && Objects.equals(this.getState(), klepka.getState())
        && Objects.equals(this.getLocation(), klepka.getLocation());
    }

    @Override 
    public String toString()
    {
    	return String.format("Klepka(name=%s)",this.getName());
    }

    @Override
    public int hashCode()
    {
    	return 231*Objects.hash("Клепка",this.getName(),this.getState(),this.getLocation());
    }	
}