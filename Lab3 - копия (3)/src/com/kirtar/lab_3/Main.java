package com.kirtar.lab_3;

import com.kirtar.lab_3.someObjects.interfaces.Locationable;
import com.kirtar.lab_3.someObjects.interfaces.Nameable;
import com.kirtar.lab_3.someObjects.interfaces.Stateable;
import com.kirtar.lab_3.someObjects.SomeObject;
import com.kirtar.lab_3.someObjects.characters.Policemen;
import com.kirtar.lab_3.someObjects.characters.Somebody;
import com.kirtar.lab_3.someObjects.enums.Appliance;


public class Main
{
	public static void main(String[] args)
	{
		Policemen p = new Policemen("Ïîëèöåéñêèå","íå ïðåêðàùàÿ","");
		System.out.println(p.shoot("ðóæåé",""));
		System.out.print(p.run());
		p.setLocation("âïåð¸ä");
		System.out.println(p.getLocation());
		p.setLocation(" ê ðàêåòå");
		System.out.println(p.run()+p.getLocation());
		p.setState(" Ñ ÿðîñòüþ ");
		System.out.println(p.getState()+p.pounce(" óñòàíîâëåííûå âîêðóã ïðèáîðû"));
		System.out.println(p.destroy("èõ"));
		System.out.println(p.destroy(Appliance.BAROMETER.getDescription()));
		System.out.println(p.destroy(Appliance.SEISMOGRAPH.getDescription()));
		System.out.println(p.shoot("",Appliance.RAINGAUGE.getDescription()));
		p.setLocation("íà âûøêó");
		System.out.println(p.climb()+p.getLocation());
		System.out.println(p.destroy(Appliance.ANEMOMETER.getDescription()));
		
		Somebody he = new Somebody("Îí","Ñ ýòèìè ñëîâàìè","");
		he.turnOnTheWeightlessnessDevice(p);
		p.setState("Áåñïîìîùíî ");
		System.out.print(p.getState()+p.tumble());
		p.setLocation("â âîçäóõå ");
		System.out.print(p.getLocation());
		p.setState(" áåçàëàáåðíî");
		System.out.println(p.wavingTheirArms());
		System.out.println(p.getState());
		System.out.println(p.kickYourFeet());
		System.out.println(p.wagTheBody());
		System.out.println(p.collideWithEachOther());
		System.out.println(p.soarUp());
		System.out.println(p.fallDown());
		System.out.println(p.pushOffTheGround());
		p.setLocation("êâåðõó");
		System.out.println(p.jump()+p.getLocation());
		
	}

}