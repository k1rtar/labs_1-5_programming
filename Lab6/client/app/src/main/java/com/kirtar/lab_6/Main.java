package com.kirtar.lab_6;


import java.util.Scanner;

import com.kirtar.lab_6.network.ServerConnection;
import com.kirtar.lab_6.iomanagers.*;
import com.kirtar.lab_6.messages.*;
import com.kirtar.lab_6.parsers.*;

import java.util.LinkedList;

/**
 * The main class through which the entire program is launched
 */

public class Main
{
    public static InputConsoleManager runner;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CommandParser commandParser = new CommandParser();
        ExecuteScriptManager executeManager = new ExecuteScriptManager();
        LinkedList<ClientRequest> requests = new LinkedList<ClientRequest>();
        ServerConnection connection = new ServerConnection(8888);
        System.out.println("Client started on port 8888");
        System.out.println("---Type ''help'' to view available commands---");
        runner = new InputConsoleManager(commandParser,requests,connection,executeManager);
        ExecuteScriptCommand.runner = runner;
        runner.run(scanner);
        
       

    }
}