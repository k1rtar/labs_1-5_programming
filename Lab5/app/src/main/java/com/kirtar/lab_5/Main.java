package com.kirtar.lab_5;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;
import com.kirtar.lab_5.commands.*;
import com.kirtar.lab_5.commands.concrete.*;
import com.kirtar.lab_5.models.*;
import com.kirtar.lab_5.iomanagers.*;
import com.kirtar.lab_5.parsers.*;
import java.util.LinkedList;
import java.util.Date;

/**
 * Главный класс, через который осуществляется запуск всей программы
 */

public class Main
{
    public static Date date = new Date();
    public static InputConsoleManager runner;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        InputFileManager inputManager = new InputFileManager();
        LinkedList<String> lastCommands = new LinkedList<String>();
        LinkedList<Command> commandList = new LinkedList<Command>();
        Queue<Flat> collection = new PriorityQueue<Flat>();
        try{collection = inputManager.XMLtoFlat(args[0]);}
        catch (Exception e){System.out.println("Ошибка загрузки файла! Проверьте правильность указанного пути к файлу(путь должен быть абсолютным)");}
        Receiver receiver = new Receiver(collection);
        Invoker invoker = new Invoker();
        CommandParser commandParser = new CommandParser();
        System.out.println("---Введите ''help'' для просмотра доступных команд---");
        runner = new InputConsoleManager(collection,lastCommands,receiver,commandList,invoker,commandParser);
        ExecuteScriptCommand.runner = runner;
        runner.run(scanner);
        
       

    }
}