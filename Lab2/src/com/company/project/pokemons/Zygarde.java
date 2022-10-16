package com.company.project.pokemons;

import com.company.project.movements.*;
import ru.ifmo.se.pokemon.*;


public class Zygarde extends Pokemon
{
	public Zygarde(String name, int level)
	{
		super(name,level);

		setLevel(level<=55 ? level: 55);
		
		setType(Type.DRAGON,Type.GROUND);

		double hp = 108, attack = 100,
		defense = 121, specialAttack = 81,
		specialDefense = 95, speed = 95;

		setStats(hp,attack,defense,specialAttack,specialDefense,speed);
		
		setMove(new Bulldoze(), new Haze(), new Glare(), new Crunch());
		 
		
		
	}
}