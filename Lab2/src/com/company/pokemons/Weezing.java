package com.company.pokemons;

import com.company.movements.*;
import ru.ifmo.se.pokemon.*;


public class Weezing extends Koffing
{
	public Weezing(String name, int level)
	{
		super(name,level);

		setLevel(level<=32 ? level: 32);
		
		setType(Type.POISON);

		double hp = 65, attack = 90,
		defense = 120, specialAttack = 85,
		specialDefense = 70, speed = 60;

		setStats(hp,attack,defense,specialAttack,specialDefense,speed);
		
		setMove(new Sludge(), new Tackle(), new Smog(), new DoubleHit());
		 
		
		
	}
}