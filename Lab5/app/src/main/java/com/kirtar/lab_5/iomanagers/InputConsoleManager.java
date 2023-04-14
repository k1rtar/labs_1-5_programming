package com.kirtar.lab_5.iomanagers;


import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

import com.kirtar.lab_5.commands.*;
import com.kirtar.lab_5.commands.concrete.*;
import com.kirtar.lab_5.models.*;
import com.kirtar.lab_5.parsers.*;

/**
 * Парсинг всех команд. Вызов их на исполнение.
 * Работа, как в интерактивном режиме, так и при считывании файла
 */
public class InputConsoleManager
{
        public Queue<Flat> collection;
        public LinkedList<String> lastCommands;
        public Receiver receiver;
        public LinkedList<Command> commandList;
        public Invoker invoker;
        public CommandParser commandParser;
        public LinkedList<String> executedFiles = new LinkedList<String>();
        public InputConsoleManager(Queue<Flat> collection,LinkedList<String> lastCommands,Receiver receiver,
        LinkedList<Command> commandList,Invoker invoker,CommandParser commandParser)
        {
            this.collection = collection;
            this.lastCommands = lastCommands;
            this.receiver = receiver;
            this.commandList = commandList;
            this.invoker = invoker;
            this.commandParser = commandParser;
            
        }
        public void run(Scanner scanner)
        {
        String input;

        do{
            if(!scanner.hasNextLine()){
                return;
            }
            input = scanner.nextLine();
            boolean commandEnteredCorrectly = false;

            if (input.equals("clear"))
            {
                commandList.addLast(new ClearCommand(receiver));
                invoker.executeFirstCommand(commandList); 
                lastCommands.add("clear");
                commandEnteredCorrectly = true;
            }


            if (input.equals("help"))
            {
                commandList.addLast(new HelpCommand(receiver));
                invoker.executeFirstCommand(commandList);
                lastCommands.add("help");
                commandEnteredCorrectly = true;
            }
            if (input.equals("show"))
            {
                commandList.addLast(new ShowCommand(receiver));
                System.out.println(commandList.getFirst());
                invoker.executeFirstCommand(commandList);
                lastCommands.add("show");
                commandEnteredCorrectly = true;
            }
            if (input.equals("history"))
            {
                commandList.addLast(new HistoryCommand(receiver,lastCommands));
                invoker.executeFirstCommand(commandList);
                lastCommands.add("history");
                commandEnteredCorrectly = true;
            }
            if (input.equals("remove_first"))
            {
                commandList.addLast(new RemoveFirstCommand(receiver));
                invoker.executeFirstCommand(commandList);
                lastCommands.add("remove_first");
                commandEnteredCorrectly = true;
            } 
            if (input.equals("add"))
            {
                commandEnteredCorrectly = true;
                Flat flat = commandParser.ParseFlatObject(scanner);
                if (flat!=null){
                    commandList.addLast(new AddCommand(receiver,flat));
                    lastCommands.add("add");
                    invoker.executeFirstCommand(commandList);
                }
            
            }
            if (input.equals("save"))
            {
                commandEnteredCorrectly = true;
                commandList.addLast(new SaveCommand(receiver,collection));
                invoker.executeFirstCommand(commandList);
                commandEnteredCorrectly = true; 
                lastCommands.add("save");

            }
            if (input.length()>=6 && input.substring(0,6).equals("update"))
            {
                String[] inputArray = input.split(" ");
                Long id = 0L;
                boolean flag = true;
                try{id = Long.parseLong(inputArray[1]);}
                catch (Exception e) {System.out.println("Ошибка! Введённый id некорректен");flag=false;}
                commandEnteredCorrectly = true;
                if (flag)
                {
                    Flat flatup = commandParser.ParseFlatObject(scanner);
                    if (flatup!=null){
                        flatup.setId(id);
                        commandList.addLast(new UpdateCommand(receiver,flatup));
                        lastCommands.add("update");
                        invoker.executeFirstCommand(commandList);
                    }
                }
            }
            if (input.length()>=12 && input.substring(0,12).equals("remove_by_id"))
            {
                String[] inputArray = input.split(" ");
                Long id = 0L;
                boolean flag = true;
                try{id = Long.parseLong(inputArray[1]);}
                catch (Exception e) {System.out.println("Ошибка! Введённый id некорректен");flag=false;}
                commandEnteredCorrectly = true;
                if (flag)
                {
                    commandList.addLast(new RemoveByIdCommand(receiver,id));
                    lastCommands.add("remove_by_id");
                    invoker.executeFirstCommand(commandList);     
                }  
            }
            if (input.equals("exit")){commandEnteredCorrectly = true;}    
            
            if (input.length()>14 && input.substring(0,14).equals("execute_script"))
            {
                String[] inputArray = input.split(" ");
                if (executedFiles.contains(inputArray[1]))
                {
                    System.out.println("Обнаружена рекурсия! Осуществляется выход из рекурсии!"+inputArray[1]);
                    scanner.close();
                    return;
                }
                executedFiles.add(inputArray[1]);
                commandEnteredCorrectly = true;
                commandList.addLast(new ExecuteScriptCommand(receiver, inputArray[1]));
                lastCommands.add("execute_script");
                invoker.executeFirstCommand(commandList);
                executedFiles.removeLast();
            }
            
            if (input.equals("info"))
            {
                commandList.addLast(new InfoCommand(receiver));
                invoker.executeFirstCommand(commandList);
                lastCommands.add("info");
                commandEnteredCorrectly = true;                
            }

            if (input.equals("remove_lower"))
            {
                commandEnteredCorrectly = true;
                Flat flat = commandParser.ParseFlatObject(scanner);
                if (flat!=null){
                    commandList.addLast(new RemoveLowerCommand(receiver,flat));
                    lastCommands.add("remove_lower");
                    invoker.executeFirstCommand(commandList);
                }
            }

            if (input.equals("group_counting_by_area"))
            {
                commandList.addLast(new GroupCountingCommand(receiver));
                invoker.executeFirstCommand(commandList);
                lastCommands.add("group_counting_by_area");
                commandEnteredCorrectly = true;                
            }

            if (input.length()>23 && input.substring(0,23).equals("filter_starts_with_name"))
            {
                String[] inputArray = input.split(" ");
                commandList.addLast(new FilterNameCommand(receiver,inputArray[1]));
                invoker.executeFirstCommand(commandList);
                lastCommands.add("filter_starts_with_name");
                commandEnteredCorrectly = true;                  
            }

            if (input.equals("print_unique_view"))
            {
                commandList.addLast(new PrintUniqueViewCommand(receiver));
                invoker.executeFirstCommand(commandList);
                lastCommands.add("print_unique_view");
                commandEnteredCorrectly = true;                  
            }
            
            if (lastCommands.size()==12){lastCommands.removeFirst();}
            if (!commandEnteredCorrectly)
            {
                System.out.println("Неправильно введена команда. Соблюдайте шаблон команды, указанный в справке доступных команд.");
                System.out.println("Для вызова справки доступных команд введите ''help'' без кавычек");
            }

        }while ( !input.equals("exit") && scanner.hasNextLine());
        scanner.close();
        return;
        }
    
}