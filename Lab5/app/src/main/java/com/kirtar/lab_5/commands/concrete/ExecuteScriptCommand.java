package com.kirtar.lab_5.commands.concrete;

import com.kirtar.lab_5.commands.Command;
import com.kirtar.lab_5.commands.Receiver;
import com.kirtar.lab_5.iomanagers.InputConsoleManager;
import com.kirtar.lab_5.Main;

/**
 * считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */

public class ExecuteScriptCommand implements Command
{
    public static InputConsoleManager runner = Main.runner;
    private Receiver receiver;
    private String filename;
    public ExecuteScriptCommand(Receiver receiver,String filename)
    {
        this.receiver = receiver;
        this.filename = filename;
    }

    @Override
    public void execute()
    {
        receiver.execute_script(filename,runner);
    }
}
