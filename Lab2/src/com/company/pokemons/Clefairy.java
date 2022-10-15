package com.company.pokemons;

import com.company.movements.*;
import ru.ifmo.se.pokemon.*;


public class Clefairy extends Cleffa
{
	public Clefairy(String name, int level)
	{
		super(name,level);

		setLevel(level<=87 ? level: 87);
		
		setType(Type.FAIRY);

		double hp = 70, attack = 45,
		defense = 48, specialAttack = 60,
		specialDefense = 65, speed = 35;

		setStats(hp,attack,defense,specialAttack,specialDefense,speed);
		
		setMove(new WorkUp(),new Swagger(),new Moonblast());
		 
		
		
	}
}