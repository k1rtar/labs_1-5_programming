package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;
import com.kirtar.lab_5.models.Flat;
import com.kirtar.lab_5.iomanagers.InputFileManager;
import java.util.Queue;

/**
 * сохранить коллекцию в файл
 */

public class SaveCommand implements Command
{
    private Queue<Flat> collection;
    private Receiver receiver;
    private String path = InputFileManager.path;

    public SaveCommand(Receiver receiver, Queue<Flat> collection)
    {
        this.receiver = receiver;
        this.collection = collection;
    }
    
    @Override
    public void execute()
    {
        receiver.save(collection,path);
    }
}
