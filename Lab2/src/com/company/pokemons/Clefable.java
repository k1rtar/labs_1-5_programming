package com.company.pokemons;

import com.company.movements.*;
import ru.ifmo.se.pokemon.*;


public class Clefable extends Clefairy
{
	public Clefable(String name, int level)
	{
		super(name,level);

		setLevel(level<=87 ? level: 87);
		
		setType(Type.FAIRY);

		double hp = 95, attack = 70,
		defense = 73, specialAttack = 95,
		specialDefense = 90, speed = 60;

		setStats(hp,attack,defense,specialAttack,specialDefense,speed);
		
		setMove(new WorkUp(),new Swagger(),new Moonblast(),new Sing());
		 
		
		
	}
}