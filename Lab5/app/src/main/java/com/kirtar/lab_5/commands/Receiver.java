package com.kirtar.lab_5.commands;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collection;
import java.util.LinkedList;
import com.kirtar.lab_5.models.Flat;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.dataformat.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
//import com.kirtar.lab_5.iomanagers.*;

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
    }


}