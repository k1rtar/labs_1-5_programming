package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;
import com.kirtar.lab_5.models.Flat;

/**
 * обновить значение элемента коллекции, id которого равен заданному
 */

public class UpdateCommand implements Command
{
    private Receiver receiver;
    private Flat flat;
    public UpdateCommand(Receiver receiver, Flat flat)
    {
        this.receiver = receiver;
        this.flat = flat;
    }
    @Override
    public void execute()
    {
        receiver.update(flat);
    }
}
