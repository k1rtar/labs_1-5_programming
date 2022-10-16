package com.company.project.pokemons;

import com.company.project.movements.*;
import ru.ifmo.se.pokemon.*;


public class Cleffa extends Pokemon
{
	public Cleffa(String name, int level)
	{
		super(name,level);

		setLevel(level<=87 ? level: 87);
		
		setType(Type.FAIRY);

		double hp = 50, attack = 25,
		defense = 28, specialAttack = 45,
		specialDefense = 55, speed = 15;

		setStats(hp,attack,defense,specialAttack,specialDefense,speed);
		
		setMove(new WorkUp(),new Swagger());
		 
		
		
	}
}