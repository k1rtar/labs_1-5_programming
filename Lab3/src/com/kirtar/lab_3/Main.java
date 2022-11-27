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
		
	}

}