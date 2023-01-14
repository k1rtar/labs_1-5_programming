
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

		PoliceSquadLeader Rigl = new PoliceSquadLeader("Ригль","","");
		System.out.println(Rigl.putHandsToMouth(" рупором ")+" "+Rigl.scream(" издали"));
		Znayka znayka = new Znayka("Знайка","","");
		System.out.println(znayka.observe(" что полицейские взяли на изготовку ружья "));
		System.out.println(znayka.command("","коротышкам"));

		
		Shorties shorties = new Shorties("Коротышки","","");
		System.out.println(shorties.skip("вперёд","Фуксию и Селёдочку"));
		System.out.println(shorties.climbed(" один за другим ","в ракету "));
		
		Klepka klepka = new Klepka("Клёпка","","");
		if (klepka.getName() != "Клёпка")
		{
			throw new KlepkaException();
		}
		klepka.setLocation(" обычно оказывавшийся впереди всех, но на этот раз оказался позади ");
		System.out.println(klepka.getName()+klepka.getLocation());	
		//System.out.println(klepka.feel(" "))

		Policemen p = new Policemen("Полицейские","не прекращая","");
		System.out.println(p.shoot("ружей",""));
		System.out.print(p.run());
		p.setLocation("вперёд");
		System.out.println(p.getLocation());
		p.setLocation(" к ракете");
		System.out.println(p.run()+p.getLocation());
		p.setState(" С яростью ");
		System.out.println(p.getState()+p.pounce(" установленные вокруг приборы"));
		System.out.println(p.destroy("их"));
		System.out.println(p.destroy(Appliance.BAROMETER.getDescription()));
		System.out.println(p.destroy(Appliance.SEISMOGRAPH.getDescription()));
		System.out.println(p.shoot("",Appliance.RAINGAUGE.getDescription()));
		p.setLocation("на вышку");
		System.out.println(p.climb()+p.getLocation());
		System.out.println(p.destroy(Appliance.ANEMOMETER.getDescription()));
		
		Somebody he = new Somebody("Он","С этими словами","");
		he.turnOnTheWeightlessnessDevice(p);
		p.setState("Беспомощно ");
		System.out.print(p.getState()+p.tumble());
		p.setLocation("в воздухе ");
		System.out.print(p.getLocation());
		p.setState(" безалаберно");
		System.out.println(p.wavingTheirArms());
		System.out.println(p.getState());
		System.out.println(p.kickYourFeet());
		System.out.println(p.wagTheBody());
		System.out.println(p.collideWithEachOther());
		System.out.println(p.soarUp());
		System.out.println(p.fallDown());
		System.out.println(p.pushOffTheGround());
		p.setLocation("кверху");
		System.out.println(p.jump()+p.getLocation());
		//PoliceSquadLeader Rigl = new PoliceSquadLeader("Ригль","","");
		//System.out.println(Rigl.scream("барабарабере"));
		//Znayka znayka = new Znayka("Знайка","","");
		//System.out.println(znayka.said(" что-то"));
		//Shorties shorties = new Shorties("Коротышки","","");
		//System.out.println(shorties.startConstruction());
		/*Klepka klepka = new Klepka("Клёпка","","");
		if (klepka.getName() != "клёпка")
		{
			throw new KlepkaException();
		}
		System.out.println(klepka.bearThePain(""));
		System.out.println(klepka.beInjured(" от боли,"));*/
	

		
		
		try
		{		
			TimeOfDay day = new TimeOfDay("День");
			System.out.println(day.comes());
		}
		catch (TimeOfDayError e)
		{
			System.out.println(e.getMessage());
		}
		String[] details = new String[12];
		details[0] = "бак для кипячения воды";
		details[1] = "бур для сверления скважин";
		details[2] = " стиральная машина";
		details[3] = "плуг для вспашки земли";
		details[4] = "центробежный насос с разбрызгивателем для поливки растений";
		details[5] = "аппарат для очистки и кондиционирования воздуха";
		details[6] = "динамо-машина для выработки электроэнергии";
		details[7] = "коротковолновая радиостанция";
		details[8] = "канавокопатель";
		details[9] = "пылесос";
		details[10] = "колёса";
		details[11] = "циркулярная пила";
		
		Constructable Vintik = new Constructable()
			{
				public void construct(String something,String[] details)
				{
					System.out.println("Винтик принялся собирать "+something);
					for(int i =0;i<details.length;i++)
					{
						System.out.println(details[i]);
					}
				}
				
			};
		Vintik.construct("универсальный вездеход",details);
		System.out.println(details.length);
		
		Action action = new Action("Глава тридцать первая. Колосок получает семена гигантских растений","","");
		System.out.println(action.getName());

		
	}

}