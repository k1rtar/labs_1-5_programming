package com.kirtar.lab_4.someObjects.enums;

import com.kirtar.lab_4.someObjects.SomeObject;

public enum Appliance
{
	BAROMETER("барометр"){public void action(String p, SomeObject someObject){}},
	SEISMOGRAPH("сейсмограф"){public void action(String p, SomeObject someObject){}},
	RAINGAUGE("дождемер"){public void action(String p, SomeObject someObject){}},
	ANEMOMETER("анемометр"){public void action(String p, SomeObject someObject){}},
	WEIGHTLESSNESSDEVICE("прибор невесомости"){
		public void action(String p,SomeObject someObject)
		{
			if (p=="вкл")
			{
				System.out.println(someObject.getName()+" в невесомости, почва ушла из под ног");
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