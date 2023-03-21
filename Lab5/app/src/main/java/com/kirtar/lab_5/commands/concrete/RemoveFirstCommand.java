package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;


public class RemoveFirstCommand implements Command{

    private Receiver receiver;

    public RemoveFirstCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        receiver.remove_first();
    }
}
