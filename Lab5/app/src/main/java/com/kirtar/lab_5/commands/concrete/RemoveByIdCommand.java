package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;

public class RemoveByIdCommand implements Command
{
    private Receiver receiver;
    private Long id;
    public RemoveByIdCommand(Receiver receiver, Long id)
    {
        this.receiver = receiver;
        this.id = id;
    }
    @Override
    public void execute()
    {
        receiver.removeById(id);
    }

}
