package com.kirtar.lab_6.iomanagers;

import java.util.Scanner;

import java.util.LinkedList;

import com.kirtar.lab_6.messages.*;
import com.kirtar.lab_6.models.*;
import com.kirtar.lab_6.parsers.*;
import com.kirtar.lab_6.network.ServerConnection;
import com.kirtar.lab_6.iomanagers.ExecuteScriptManager;
/**
 * Parsing of all commands. Call them for execution.
 * Work, both in interactive mode and when reading a file
 */
public class InputConsoleManager
{

        public CommandParser commandParser;
        public LinkedList<ClientRequest> requests;
        ExecuteScriptManager executeManager;
        public LinkedList<String> executedFiles = new LinkedList<String>();
        public ServerConnection connection;
        public InputConsoleManager(CommandParser commandParser, LinkedList<ClientRequest> requests,ServerConnection connection,ExecuteScriptManager executeManager)
        {
            this.commandParser = commandParser;
            this.requests = requests;
            this.connection = connection;
            this.executeManager = executeManager;
        }
        public void run(Scanner scanner)
        {
        String input;
        ClientRequest<?> request = new ClientRequest<String>("help","");
        ServerResponse response = new ServerResponse(ResultStatus.OK,"Events did not happen");
        do{
            if(!scanner.hasNextLine()){
                return;
            }
            input = scanner.nextLine();
            boolean commandEnteredCorrectly = false;
            boolean requestCreated = false;
            
            if (input.equals("info"))
            {
                request = new ClientRequest<String>(input, "");
                requestCreated = true;
                requests.addLast(request);
            }

            if (input.equals("show")){
            request = new ClientRequest<String>(input,"");
            requestCreated = true; 
            requests.addLast(request);}
            
            if (input.equals("clear"))
            {
                request = new ClientRequest<String>("clear", "");
                requestCreated = true;
                requests.addLast(request);
            }


            if (input.equals("help"))
            {
                request = new ClientRequest<String>("help", "");
                requestCreated = true;
                requests.addLast(request);
            }

            if (input.equals("add"))
            {
                Flat flat = commandParser.ParseFlatObject(scanner);
                if (flat!=null)
                {
                    request = new ClientRequest<Flat>("add", flat);
                    requestCreated = true;
                    requests.addLast(request);
                }
            }

            if (input.equals("remove_lower"))
            {
                Flat flat = commandParser.ParseFlatObject(scanner);
                if (flat!=null)
                {
                    request = new ClientRequest<Flat>(input, flat);
                    requestCreated = true;
                    requests.addLast(request);
                }
            }

            if (input.length()>=6 && input.substring(0,6).equals("update"))
            {
                String[] inputArray = input.split(" ");
                Long id = 0L;
                boolean flag = true;
                try{id = Long.parseLong(inputArray[1]);}
                catch (Exception e) {System.out.println("Error! The entered id is invalid");flag=false;}
                if (flag)
                {
                    Flat flatup = commandParser.ParseFlatObject(scanner);
                    if (flatup!=null){
                        flatup.setId(id);
                        request = new ClientRequest<Flat>("update", flatup);
                        requestCreated = true;
                        requests.addLast(request);
                        };
                    }
                }
            if (input.length()>14 && input.substring(0,14).equals("execute_script"))
                {
                    String[] inputArray = input.split(" ");
                    if (executedFiles.contains(inputArray[1]))
                    {
                        System.out.println("Recursion detected! The recursion is exiting!"+inputArray[1]);
                        scanner.close();
                        return;
                    }
                    executedFiles.add(inputArray[1]);
                    ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand(executeManager, inputArray[1]); 
                    executeScriptCommand.execute();
                    //requests.add(request);
                    executedFiles.removeLast();
                    commandEnteredCorrectly = true;
                }
                if (input.length()>=12 && input.substring(0,12).equals("remove_by_id"))
                {
                    String[] inputArray = input.split(" ");
                    Long id = 0L;
                    boolean flag = true;
                    try{id = Long.parseLong(inputArray[1]);}
                    catch (Exception e) {System.out.println("Error! The entered id is invalid");flag=false;}
                    commandEnteredCorrectly = true;
                    if (flag)
                    {
                        request = new ClientRequest<Long>("remove_by_id",id);
                        requestCreated = true;
                        requests.addLast(request); 
                    }  
                }
                
                if (input.equals("remove_first"))
                {
                    request = new ClientRequest<String>("remove_first", "");
                    requestCreated = true;
                    requests.addLast(request);
                } 

                if (input.equals("group_counting_by_area"))
                {
                    request = new ClientRequest<String>("group_counting_by_area", "");
                    requestCreated = true;
                    requests.addLast(request);           
                }

                try{
                if (input.length()>24 && input.substring(0,23).equals("filter_starts_with_name"))
                {
                    String[] inputArray = input.split(" ");
                    request = new ClientRequest<String>("filter_starts_with_name", inputArray[1]);
                    requestCreated = true;
                    requests.addLast(request);                  
                }}
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("The name cannot contain empty characters");
                }

                if (input.equals("print_unique_view"))
                {
                    request = new ClientRequest<String>("print_unique_view", "");
                    requestCreated = true;
                    requests.addLast(request);                   
                }
                if (input.equals("history"))
                {
                    request = new ClientRequest<String>("history", "");
                    requestCreated = true;
                    requests.addLast(request);                   
                }
            if (requestCreated)
            {
                try{response = connection.processTheRequest(request);} 
                catch (Exception e){System.out.println("Request not created");}
                if (response.status == ResultStatus.OK){System.out.println(response.message);commandEnteredCorrectly = true;}
                else{System.out.println("An error has occurred: "+ response.message);}
            }
            
            if (input.equals("exit")){commandEnteredCorrectly = true;}  

            if (!commandEnteredCorrectly)
            {
                System.out.println("Command entered incorrectly. Follow the command pattern specified in the available command help.");
                System.out.println("For help on available commands, type ''help'' without quotes");
            }

        }while ( !input.equals("exit") && scanner.hasNextLine());
        scanner.close();
        return;
        }
    
}