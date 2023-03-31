package com.kirtar.lab_5.commands;

import java.util.PriorityQueue;
import java.util.LinkedList;

import com.kirtar.lab_5.iomanagers.InputConsoleManager;
import com.kirtar.lab_5.Main;
import com.kirtar.lab_5.models.Flat;
import com.kirtar.lab_5.models.View;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet; 

/**
 * Реализация всех команд, класс-исполнитель
 */
public class Receiver
{
    private PriorityQueue<Flat> collection;

    public Receiver(PriorityQueue<Flat> collection)
    {
        this.collection = collection;
    }

    public void add(Flat element)
    {
        collection.add(element);
    }

    public void clear()
    {
        collection.clear();
        System.out.println("CLEAR");
    }

    public void help()
    {
        System.out.println("help : вывести справку по доступным командам\ninfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\nadd {element} : добавить новый элемент в коллекцию\nupdate id {element} : обновить значение элемента коллекции, id которого равен заданному\nremove_by_id id : удалить элемент из коллекции по его id\nclear : очистить коллекцию\nsave : сохранить коллекцию в файл\nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\nexit : завершить программу (без сохранения в файл)\nremove_first : удалить первый элемент из коллекции\nremove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\nhistory : вывести последние 11 команд (без их аргументов)\ngroup_counting_by_area : сгруппировать элементы коллекции по значению поля area, вывести количество элементов в каждой группе\nfilter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\nprint_unique_view : вывести уникальные значения поля view всех элементов в коллекции");
    }

    public void show()
    {
        System.out.println("Элементы коллекции: ");
        for (Flat element: collection)
        {
            System.out.println(element);
        }
    }

    public void history(LinkedList<String> lastCommands)
    {
        System.out.println("Последние 11 команд: ");
        for(String command: lastCommands)
        {
            System.out.println(command);
        }

    }

    public void remove_first()
    {
        collection.poll();
        System.out.println("REMOVE_FIRST");
    }

    public void save(PriorityQueue<Flat> collection, String path)
    {
        String result = "";
        try{
        for (Flat el: collection)
        {
            
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String xmlString = xmlMapper.writeValueAsString(el);
            result+=xmlString;
        }
        System.out.println(result);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                      new FileOutputStream(path));
        bufferedOutputStream.write(result.getBytes());
        bufferedOutputStream.close();
        System.out.println("SAVE");
    }
    catch (Exception e)
    {
        System.out.println("Ошибка записи коллекции в файл");
        e.printStackTrace();
    }


    }

    public void update(Flat flat)
    {

        for (Flat el: collection)
        {
            if (el.getId().equals(flat.getId()))
            {
                el.setName(flat.getName());
                el.setCoordinates(flat.getCoordinates());
                el.setArea(flat.getArea());
                el.setNumberOfRooms(flat.getNumberOfRooms());
                el.setNumberOfBathrooms(flat.getNumberOfBathrooms());
                el.setView(flat.getView());
                el.setTransport(flat.getTransport());
                el.setHouse(flat.getHouse());      
                break;      

            }
        }
        System.out.println("UPDATE");
    }
    public void removeById(Long id)
    {
        for (Flat el:collection)
        {
            if (el.getId().equals(id))
            {
                el.setId(-100000000L);
                collection.poll();
                break;
            }
        }
        System.out.println("REMOVE_BY_ID");
    }

    public void execute_script(String filename, InputConsoleManager runner)
    {
        try{
        Scanner scanner = new Scanner(new File(filename));
        
        runner.run(scanner);
        System.out.println("EXECUTE_SCRIPT");
        }
        catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл("+filename+") не найден");
        }
    }

    public void info()
    {
        System.out.println("---Информация о коллекции---");
        System.out.println("Тип коллекции: "+collection.getClass().toString());
        System.out.println("Дата инициализации: "+Main.date);
        System.out.println("Количество элементов: "+collection.size());
    }

    public void remove_lower(Flat flat)
    {
        Iterator<Flat> it = collection.iterator();
        while (it.hasNext())
        {
            Flat nextFlat = it.next();
            if (flat.getNumberOfRooms()>nextFlat.getNumberOfRooms())
            {
                it.remove();
            }
        }
        System.out.println("REMOVE_LOWER");
        
    }

    public void group_counting_by_area()
    {

        Map<Double,Integer> dictionary = new HashMap<Double,Integer>();
        for(Flat el: collection)
        {
            dictionary.put(el.getArea(),0);
        }
        for(Flat el: collection)
        {
            dictionary.put(el.getArea(),dictionary.get(el.getArea())+1);
        }
        for(Map.Entry<Double, Integer> item : dictionary.entrySet()){
         
            System.out.printf("Area: %f  Amount of elements: %d \n", item.getKey(), item.getValue());
        }
    }

    public void filter_starts_with_name(String name)
    {
        for (Flat el:collection)
        {
            if (el.getName().substring(0,name.length()).equals(name))
            {
                System.out.println(el);
            }
        }
        System.out.println("FILTER_STARTS_WITH_NAME");
    }

    public void print_unique_view()
    {
        HashSet<View> viewSet = new HashSet<View>();
        for (Flat el:collection)
        {
            viewSet.add(el.getView());
        }
        for (View el:viewSet)
        {
            System.out.println(el);
        }
        System.out.println("PRINT_UNIQUE_VIEW");
    }

}