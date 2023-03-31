package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;

/**
 * сгруппировать элементы коллекции по значению поля area, вывести количество элементов в каждой группе
 */

public class GroupCountingCommand implements Command
{
    private Receiver receiver;
    public GroupCountingCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        receiver.group_counting_by_area();
    }
}


