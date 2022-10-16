package com.company.project.pokemons;

import com.company.project.movements.*;
import ru.ifmo.se.pokemon.*;


public class Koffing extends Pokemon
{
	public Koffing(String name, int level)
	{
		super(name,level);

		setLevel(level<=32 ? level: 32);
		
		setType(Type.POISON);

		double hp = 40, attack = 65,
		defense = 95, specialAttack = 60,
		specialDefense = 45, speed = 35;

		setStats(hp,attack,defense,specialAttack,specialDefense,speed);
		
		setMove(new Sludge(), new Tackle(), new Smog());
		 
		
		
	}
}