package com.kirtar.lab_3.someObjects.enums;

import com.kirtar.lab_3.someObjects.SomeObject;

public enum Appliance
{
	BAROMETER("áàðîìåòð"){public void action(String p, SomeObject someObject){}},
	SEISMOGRAPH("ñåéñìîãðàô"){public void action(String p, SomeObject someObject){}},
	RAINGAUGE("äîæäåìåð"){public void action(String p, SomeObject someObject){}},
	ANEMOMETER("àíåìîìåòð"){public void action(String p, SomeObject someObject){}},
	WEIGHTLESSNESSDEVICE("ïðèáîð íåâåñîìîñòè"){
		public void action(String p,SomeObject someObject)
		{
			if (p=="âêë")
			{
				System.out.println(someObject.getName()+" â íåâåñîìîñòè, ïî÷âà óøëà èç ïîä íîã");
			}
		}		
	};


	private String description;

	Appliance(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}
	public abstract void action(String p, SomeObject someObject);
}