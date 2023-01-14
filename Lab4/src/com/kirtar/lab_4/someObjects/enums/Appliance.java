package com.kirtar.lab_4.someObjects.enums;

import com.kirtar.lab_4.someObjects.SomeObject;

public enum Appliance
{
	BAROMETER("��������"){public void action(String p, SomeObject someObject){}},
	SEISMOGRAPH("����������"){public void action(String p, SomeObject someObject){}},
	RAINGAUGE("��������"){public void action(String p, SomeObject someObject){}},
	ANEMOMETER("���������"){public void action(String p, SomeObject someObject){}},
	WEIGHTLESSNESSDEVICE("������ �����������"){
		public void action(String p,SomeObject someObject)
		{
			if (p=="���")
			{
				System.out.println(someObject.getName()+" � �����������, ����� ���� �� ��� ���");
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