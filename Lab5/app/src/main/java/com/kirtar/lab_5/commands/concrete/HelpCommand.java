package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;

public class HelpCommand implements Command
{
    private Receiver receiver;
    public HelpCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        receiver.help();
    }
}


