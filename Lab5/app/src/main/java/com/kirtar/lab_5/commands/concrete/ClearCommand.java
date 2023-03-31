package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;


/**
 * очистить коллекцию
 */

public class ClearCommand implements Command{

    private Receiver receiver;

    public ClearCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        receiver.clear();
    }
}
