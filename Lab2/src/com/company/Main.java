package com.company;

import com.company.pokemons.*;
import ru.ifmo.se.pokemon.*;



public class Main
{
	public static void main(String[] args)
	{
		Battle b = new Battle();
		Pokemon p1 = new Zygarde("Red",1);
		Pokemon p2 = new Koffing("Blue",1);
		Pokemon p3 = new Weezing("Green",1);
		Pokemon p4 = new Cleffa("Yellow",1);
		Pokemon p5 = new Clefairy("Orange",1);
		Pokemon p6 = new Clefable("White",1);
		b.addAlly(p1);
		b.addFoe(p2);
		b.addAlly(p3);
		b.addFoe(p4);
		b.addAlly(p5);
		b.addFoe(p6);
		b.go();
	}
}