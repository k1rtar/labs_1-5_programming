package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;
import com.kirtar.lab_5.models.Flat;

public class AddCommand implements Command{

    private Receiver receiver;
    private Flat element;

    public AddCommand(Receiver receiver, Flat element)
    {
        this.receiver = receiver;
        this.element = element;
    }

    @Override
    public void execute()
    {
        receiver.add(element);
    }
}
