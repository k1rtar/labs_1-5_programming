package com.company.movements;

import ru.ifmo.se.pokemon.*;

public class Smog extends SpecialMove
{
	public Smog()
	{
		super(Type.POISON,30,70);
	}
	
	@Override
	protected String describe()
	{
		return "использует Smog";
	}
	@Override
	protected void applyOppEffects(Pokemon p)
	{
		if (Math.random()<=0.4)
		{
			Effect.poison(p);
		}
	}
	
	
}