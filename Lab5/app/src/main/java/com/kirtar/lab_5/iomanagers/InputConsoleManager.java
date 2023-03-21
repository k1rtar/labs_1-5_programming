//работа с консольными командами
package com.kirtar.lab_5.iomanagers;
import java.util.Objects;
import java.io.*;
import java.util.Queue;
import java.util.PriorityQueue;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.LinkedList;

import com.kirtar.lab_5.commands.*;
import com.kirtar.lab_5.commands.concrete.*;
import com.kirtar.lab_5.models.*;
import com.kirtar.lab_5.parsers.*;

import com.kirtar.lab_5.models.IdFlat;
public class InputConsoleManager
{

   
        public void run(Scanner scanner, PriorityQueue<Flat> collection)
        {
        String input;
        LinkedList<String> lastCommands = new LinkedList<String>();
        Coordinates coor = new Coordinates(1,2.0F);
        House houser = new House("dfgdgd",474646,345);
        Flat flatingo = new Flat("flatilio",coor,23.0,34,234,View.STREET,Transport.NORMAL,houser);
        //PriorityQueue<Flat> collection = new PriorityQueue<Flat>();
        Receiver receiver = new Receiver(collection);
        LinkedList<Command> commandList = new LinkedList<Command>();
        commandList.addLast(new AddCommand(receiver,flatingo));
        //commandList.addLast(new ClearCommand(receiver));
        //commandList.addLast(new HelpCommand(receiver));
        //commandList.addLast(new ShowCommand(receiver));
        //commandList.addLast(new HistoryCommand(receiver,lastCommands))
        Invoker invoker = new Invoker();
        invoker.executeFirstCommand(commandList);
        CommandParser commandParser = new CommandParser();
        do{
            if(!scanner.hasNextLine()){
                return;
            }
            input = scanner.nextLine();
            boolean commandEnteredCorrectly = false;
            /*FIXMEEEEEtry {
                cm.ParseAndExecute(input);
            }
            catch (Exception e){
                System.out.println("Произошла ошибка: " + e.getMessage());
            }*/
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
                
                /*Long id;String name;int x; float y;
                System.out.println("Введите id: ");
                input = scanner.nextLine();
                try{id = Long.parseLong(input);}catch (Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле id!");continue;}
                System.out.println("Введите name: ");
                input = scanner.nextLine();
                try{name = input;} catch (Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле name!"); continue;}
                System.out.println("Ввод coordinates");
                System.out.println("Введите x: ");
                input = scanner.nextLine();
                try{x = Integer.parseInt(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле x!"); continue;}
                System.out.println("Введите y: ");
                input = scanner.nextLine();
                try{y = Float.parseFloat(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле y!"); continue;}
                double area; int numberOfRooms; long numberOfBathrooms;
                //View view, Transport transport, House house
                System.out.println("Введите area: ");
                input = scanner.nextLine();
                try{area = Double.parseDouble(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле area!"); continue;}
                System.out.println("Введите numberOfRooms: ");
                input = scanner.nextLine();
                try{numberOfRooms= Integer.parseInt(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfRooms!"); continue;}
                System.out.println("Введите numberOfBathrooms: ");
                input = scanner.nextLine();
                try{numberOfBathrooms= Long.parseLong(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfBathrooms!"); continue;}
                View view; Transport transport; House house;
                System.out.println("Введите view: ");
                input = scanner.nextLine();
                try{view= View.valueOf(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле view!"); continue;}
                System.out.println("Введите transport:");
                input = scanner.nextLine();
                try{transport= Transport.valueOf(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле transport!"); continue;}
                String houseName;long year;Integer numberOfLifts;
                System.out.println("Ввод house");
                System.out.println("Введите name: ");
                input = scanner.nextLine();
                try{houseName = input;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле name(House)!"); continue;}
                System.out.println("Введите year: ");
                input = scanner.nextLine();
                try{year = Long.parseLong(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле year!"); continue;}
                System.out.println("Введите numberOfLifts: ");
                input = scanner.nextLine();
                try{numberOfLifts = Integer.parseInt(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfLifts!"); continue;}*/
            
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
            if (lastCommands.size()==12){lastCommands.removeFirst();}
            if (!commandEnteredCorrectly)
            {
                System.out.println("Неправильно введена команда. Соблюдайте шаблон команды, указанный в справке доступных команд.");
                System.out.println("Для вызова справки доступных команд введите ''help'' без кавычек");
            }

        }while ( !input.equals("exit") );
        }
    
}