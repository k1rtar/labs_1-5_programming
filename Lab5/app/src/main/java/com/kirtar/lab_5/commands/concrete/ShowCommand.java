package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;

/**
 * вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */

public class ShowCommand implements Command
{
    private Receiver receiver;
    public ShowCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        receiver.show();
    }
}