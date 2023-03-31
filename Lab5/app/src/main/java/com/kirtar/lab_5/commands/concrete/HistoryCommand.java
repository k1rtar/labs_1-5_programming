package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;
import java.util.LinkedList;

/**
 * вывести последние 11 команд (без их аргументов)
 */

public class HistoryCommand implements Command{

    private Receiver receiver;

    private LinkedList<String> lastCommands;

    public HistoryCommand(Receiver receiver,LinkedList<String> lastCommands)
    {
        this.receiver = receiver;
        this.lastCommands = lastCommands;
    }

    @Override
    public void execute()
    {
        receiver.history(lastCommands);
    }
}
