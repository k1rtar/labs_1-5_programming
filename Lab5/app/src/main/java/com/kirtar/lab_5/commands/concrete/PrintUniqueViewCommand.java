package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;

/**
 * вывести уникальные значения поля view всех элементов в коллекции
 */

public class PrintUniqueViewCommand implements Command{

    private Receiver receiver;

    public PrintUniqueViewCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        receiver.print_unique_view();
    }
}
