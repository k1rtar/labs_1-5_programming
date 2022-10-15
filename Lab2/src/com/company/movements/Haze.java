package com.company.movements;

import ru.ifmo.se.pokemon.*;

public class Haze extends StatusMove
{
	public Haze()
	{
		super(Type.ICE,0,0);
	}
	
	@Override
	protected String describe()
	{
		return "использует Haze";
	}
	
	@Override
	protected void applyOppEffects(Pokemon p)
	{
		p.setMod(Stat.ACCURACY,-1);
		p.setMod(Stat.EVASION,-1);
	}
}