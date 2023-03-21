package com.kirtar.lab_5.commands;

import java.util.LinkedList;

import com.kirtar.lab_5.commands.*;
import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;

public class Invoker
{
    

    public void executeAllCommands(LinkedList<Command> commandList)
    {
        for (Command c: commandList)
        {
            c.execute();
        }
        commandList.clear();
    }
    public void executeFirstCommand(LinkedList<Command> commandList)
    {
        commandList.getFirst().execute();
        commandList.removeFirst();
    }

    public void executeLastCommand(LinkedList<Command> commandList)
    {
        commandList.getLast().execute();
        commandList.removeLast();
    }

    /*public void addElement()
    {
        add.execute();
    }

    public void clearTheCollection()
    {
        clear.execute();
    }

    public void help()
    {
        help.execute();
    }

    public void showCollectionItems()
    {
        show.execute();
    }

    public void showHistory()
    {
        history.execute();
    }*/


}