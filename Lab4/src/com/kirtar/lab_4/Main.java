
package com.kirtar.lab_4;

import com.kirtar.lab_4.someObjects.interfaces.Locationable;
import com.kirtar.lab_4.someObjects.interfaces.Nameable;
import com.kirtar.lab_4.someObjects.interfaces.Stateable;
import com.kirtar.lab_4.someObjects.interfaces.Constructable;
import com.kirtar.lab_4.someObjects.SomeObject;
import com.kirtar.lab_4.someObjects.characters.Policemen;
import com.kirtar.lab_4.someObjects.characters.PoliceSquadLeader;
import com.kirtar.lab_4.someObjects.characters.Znayka;
import com.kirtar.lab_4.someObjects.characters.Klepka;
import com.kirtar.lab_4.someObjects.characters.Shorties;
import com.kirtar.lab_4.someObjects.characters.Cameraman;
import com.kirtar.lab_4.someObjects.characters.DoctorPilulkin;
import com.kirtar.lab_4.someObjects.characters.Somebody;
import com.kirtar.lab_4.someObjects.phenomena.TimeOfDay;
import com.kirtar.lab_4.someObjects.phenomena.Action;
import com.kirtar.lab_4.someObjects.exceptions.TimeOfDayError;
import com.kirtar.lab_4.someObjects.exceptions.KlepkaException;
import com.kirtar.lab_4.someObjects.enums.Appliance;


public class Main
{
	public static void main(String[] args) throws KlepkaException
	{

		PoliceSquadLeader Rigl = new PoliceSquadLeader("�����","","");
		System.out.println(Rigl.putHandsToMouth(" ������� ")+" "+Rigl.scream(" ������"));
		Znayka znayka = new Znayka("������","","");
		System.out.println(znayka.observe(" ��� ����������� ����� �� ��������� ����� "));
		System.out.println(znayka.command("","����������"));

		
		Shorties shorties = new Shorties("���������","","");
		System.out.println(shorties.skip("�����","������ � ��������"));
		System.out.println(shorties.climbed(" ���� �� ������ ","� ������ "));
		
		Klepka klepka = new Klepka("�����","","");
		if (klepka.getName() != "�����")
		{
			throw new KlepkaException();
		}
		klepka.setLocation(" ������ ������������� ������� ����, �� �� ���� ��� �������� ������ ");
		System.out.println(klepka.getName()+klepka.getLocation());	
		//System.out.println(klepka.feel(" "))

		Policemen p = new Policemen("�����������","�� ���������","");
		System.out.println(p.shoot("�����",""));
		System.out.print(p.run());
		p.setLocation("�����");
		System.out.println(p.getLocation());
		p.setLocation(" � ������");
		System.out.println(p.run()+p.getLocation());
		p.setState(" � ������� ");
		System.out.println(p.getState()+p.pounce(" ������������� ������ �������"));
		System.out.println(p.destroy("��"));
		System.out.println(p.destroy(Appliance.BAROMETER.getDescription()));
		System.out.println(p.destroy(Appliance.SEISMOGRAPH.getDescription()));
		System.out.println(p.shoot("",Appliance.RAINGAUGE.getDescription()));
		p.setLocation("�� �����");
		System.out.println(p.climb()+p.getLocation());
		System.out.println(p.destroy(Appliance.ANEMOMETER.getDescription()));
		
		Somebody he = new Somebody("��","� ����� �������","");
		he.turnOnTheWeightlessnessDevice(p);
		p.setState("���������� ");
		System.out.print(p.getState()+p.tumble());
		p.setLocation("� ������� ");
		System.out.print(p.getLocation());
		p.setState(" �����������");
		System.out.println(p.wavingTheirArms());
		System.out.println(p.getState());
		System.out.println(p.kickYourFeet());
		System.out.println(p.wagTheBody());
		System.out.println(p.collideWithEachOther());
		System.out.println(p.soarUp());
		System.out.println(p.fallDown());
		System.out.println(p.pushOffTheGround());
		p.setLocation("������");
		System.out.println(p.jump()+p.getLocation());
		//PoliceSquadLeader Rigl = new PoliceSquadLeader("�����","","");
		//System.out.println(Rigl.scream("������������"));
		//Znayka znayka = new Znayka("������","","");
		//System.out.println(znayka.said(" ���-��"));
		//Shorties shorties = new Shorties("���������","","");
		//System.out.println(shorties.startConstruction());
		/*Klepka klepka = new Klepka("�����","","");
		if (klepka.getName() != "�����")
		{
			throw new KlepkaException();
		}
		System.out.println(klepka.bearThePain(""));
		System.out.println(klepka.beInjured(" �� ����,"));*/
	

		
		
		try
		{		
			TimeOfDay day = new TimeOfDay("����");
			System.out.println(day.comes());
		}
		catch (TimeOfDayError e)
		{
			System.out.println(e.getMessage());
		}
		String[] details = new String[12];
		details[0] = "��� ��� ��������� ����";
		details[1] = "��� ��� ��������� �������";
		details[2] = " ���������� ������";
		details[3] = "���� ��� ������� �����";
		details[4] = "������������ ����� � ���������������� ��� ������� ��������";
		details[5] = "������� ��� ������� � ����������������� �������";
		details[6] = "������-������ ��� ��������� ��������������";
		details[7] = "��������������� ������������";
		details[8] = "��������������";
		details[9] = "�������";
		details[10] = "�����";
		details[11] = "����������� ����";
		
		Constructable Vintik = new Constructable()
			{
				public void construct(String something,String[] details)
				{
					System.out.println("������ �������� �������� "+something);
					for(int i =0;i<details.length;i++)
					{
						System.out.println(details[i]);
					}
				}
				
			};
		Vintik.construct("������������� ��������",details);
		System.out.println(details.length);
		
		Action action = new Action("����� �������� ������. ������� �������� ������ ���������� ��������","","");
		System.out.println(action.getName());

		
	}

}