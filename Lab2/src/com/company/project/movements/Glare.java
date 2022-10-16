package com.company.project.movements;

import ru.ifmo.se.pokemon.*;

public class Glare extends StatusMove
{
	public Glare()
	{
		super(Type.NORMAL,0,100);
	}
	
	@Override
	public String describe()
	{
		return "использует Glare";
	}
	
	@Override
	protected void applyOppEffects(Pokemon p)
	{
		Effect.paralyze(p);
	}
}