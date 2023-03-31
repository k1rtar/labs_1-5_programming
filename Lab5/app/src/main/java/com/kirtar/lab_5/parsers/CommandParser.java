package com.kirtar.lab_5.parsers;

import java.util.Scanner;

import com.kirtar.lab_5.models.*;

/**
 * Парсер для команд с параметром типа Flat
 */

public class CommandParser
{

    public Flat ParseFlatObject(Scanner scanner)
    {
        String name="";int x=0; float y=0;
        System.out.println("Введите name: ");
        String input = scanner.nextLine();
        try{name = input;} catch (Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле name!"); return null;}
        if (name==null || name.isEmpty()){System.out.println("Ошибка! Поле name не может быть null!"); return null;}
        System.out.println("Ввод coordinates");
        System.out.println("Введите x: ");
        input = scanner.nextLine();
        try{x = Integer.parseInt(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле x!"); return null;}
        if (x<=-232){System.out.println("Ошибка! Значение поля x должно быть больше -232"); return null;}
        System.out.println("Введите y: ");
        input = scanner.nextLine();
        try{y = Float.parseFloat(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле y!"); return null;}
        if (y<=-150){System.out.println("Ошибка! Значение поля y должно быть больше -150"); return null;}
        double area=0; int numberOfRooms=0; long numberOfBathrooms=0;
        System.out.println("Введите area: ");
        input = scanner.nextLine();
        try{area = Double.parseDouble(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле area!"); return null;}
        if (area<=0){System.out.println("Ошибка! Значение поля area должно быть больше 0"); return null;}
        System.out.println("Введите numberOfRooms: ");
        input = scanner.nextLine();
        try{numberOfRooms= Integer.parseInt(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfRooms!"); return null;}
        if (numberOfRooms<=0){System.out.println("Ошибка! Значение поля numberOfRooms должно быть больше 0"); return null;}
        System.out.println("Введите numberOfBathrooms: ");
        input = scanner.nextLine();
        try{numberOfBathrooms= Long.parseLong(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfBathrooms!"); return null;}
        if (numberOfBathrooms<=0){System.out.println("Ошибка! Значение поля numberOfBathrooms должно быть больше 0"); return null;}
        View view=View.NORMAL; Transport transport=Transport.NORMAL;
        System.out.println("Введите view(STREET,YARD,BAD,NORMAL,GOOD): ");
        input = scanner.nextLine();
        if (input.isEmpty()){view=null;}
        else{
        try{view= View.valueOf(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле view!"); return null;}}
        System.out.println("Введите transport(FEW,NONE,LITTLE,NORMAL,ENOUGH): ");
        input = scanner.nextLine();
        try{transport= Transport.valueOf(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле transport!"); return null;}
        if (transport==null || input.isEmpty()){System.out.println("Ошибка! Поле transport не может быть null!"); return null;}
        String houseName="";long year=0;Integer numberOfLifts=0;
        System.out.println("Ввод house");
        System.out.println("Введите name: ");
        input = scanner.nextLine();
        if (input.isEmpty()){houseName = null;}else{
        try{houseName = input;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле name(House)!"); return null;}}
        System.out.println("Введите year: ");
        input = scanner.nextLine();
        try{year = Long.parseLong(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле year!"); return null;}
        if (year<=0){System.out.println("Ошибка! Значение поля year должно быть больше 0"); return null;}
        System.out.println("Введите numberOfLifts: ");
        input = scanner.nextLine();
        try{numberOfLifts = Integer.parseInt(input);} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfLifts!"); return null;}
        if (numberOfLifts<=0){System.out.println("Ошибка! Значение поля  numberOfLifts должно быть больше 0"); return null;}
        Flat flat = new Flat(name,new Coordinates(x,y), area, numberOfRooms,numberOfBathrooms,view,transport,new House(houseName,year,numberOfLifts));
        System.out.println(flat);
        return flat;
    }

        


  
}