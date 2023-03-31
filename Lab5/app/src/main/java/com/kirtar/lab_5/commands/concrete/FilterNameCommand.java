package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;

/**
 * вывести элементы, значение поля name которых начинается с заданной подстроки
 */

public class FilterNameCommand implements Command{

    private Receiver receiver;
    private String name;
    public FilterNameCommand(Receiver receiver,String name)
    {
        this.receiver = receiver;
        this.name = name;
    }

    @Override
    public void execute()
    {
        receiver.filter_starts_with_name(name);
    }
}
