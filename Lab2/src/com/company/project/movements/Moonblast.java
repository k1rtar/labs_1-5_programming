package com.company.project.movements;

import ru.ifmo.se.pokemon.*;

public class Moonblast extends SpecialMove
{
	public Moonblast()
	{
		super(Type.FAIRY,95,100);
	}
	
	@Override
	protected String describe()
	{
		return "использует Moonblast";
	}

	@Override
	protected void applyOppEffects(Pokemon p)
	{
		if (Math.random()<=0.3)
			{
				p.setMod(Stat.SPECIAL_ATTACK,-1);
			}
	}
	
	
}