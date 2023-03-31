package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;
import com.kirtar.lab_5.models.Flat;

/**
 *  удалить из коллекции все элементы, меньшие, чем заданный
 */

public class RemoveLowerCommand implements Command{

    private Receiver receiver;
    private Flat flat;
    public RemoveLowerCommand(Receiver receiver,Flat flat)
    {
        this.receiver = receiver;
        this.flat = flat;
    }

    @Override
    public void execute()
    {
        receiver.remove_lower(flat);
    }
}
