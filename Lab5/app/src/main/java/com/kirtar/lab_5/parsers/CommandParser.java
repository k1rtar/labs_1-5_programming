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
        String input;
        String name="";float x=0; int y=0;

        boolean flag = true;
        while (flag)
        {
            
            System.out.println("Введите name: ");
            input = scanner.nextLine();
            try{name = input;flag=false;} catch (Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле name!");flag=true;}
            if (name==null || name.trim().isEmpty()){System.out.println("Ошибка! Поле name не может быть null!");flag=true;}
            
        } 
        System.out.println("Ввод coordinates");
        flag = true;
        while(flag){
            System.out.println("Введите x: ");
            input = scanner.nextLine();
            try{x = Float.parseFloat(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле x!"); flag=true;}
            if (x<=-232){System.out.println("Ошибка! Значение поля x должно быть больше -232"); flag=true;}
        }

        flag = true;
        
        while(flag){
            System.out.println("Введите y: ");
            input = scanner.nextLine();
            try{y = Integer.parseInt(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле y!"); flag=true;}
            if (y<=-150){System.out.println("Ошибка! Значение поля y должно быть больше -150"); flag=true;}
        }
        double area=0; int numberOfRooms=0; long numberOfBathrooms=0;
        flag = true;
        System.out.println("Введите area: ");
        while(flag){
            input = scanner.nextLine();
            try{area = Double.parseDouble(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле area!"); flag=true;}
            if (area<=0){System.out.println("Ошибка! Значение поля area должно быть больше 0"); flag=true;}
        }
        flag = true;
        
        while (flag){
            System.out.println("Введите numberOfRooms: ");
            input = scanner.nextLine();
            try{numberOfRooms= Integer.parseInt(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfRooms!"); flag=true;}
            if (numberOfRooms<=0){System.out.println("Ошибка! Значение поля numberOfRooms должно быть больше 0"); flag=true;}
        }
        flag = true;
        
        while (flag){
            System.out.println("Введите numberOfBathrooms: ");
            input = scanner.nextLine();
            try{numberOfBathrooms= Long.parseLong(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfBathrooms!"); flag=true;}
            if (numberOfBathrooms<=0){System.out.println("Ошибка! Значение поля numberOfBathrooms должно быть больше 0"); flag=true;}
        }
        flag = true;
        View view=View.NORMAL; Transport transport=Transport.NORMAL;
        
        while (flag){
            System.out.println("Введите view(STREET,YARD,BAD,NORMAL,GOOD): ");
            input = scanner.nextLine();
            if (view==null || input.trim().isEmpty()){view = null;break;}
            if (input.isEmpty()){view=null;}
            else{
            try{view= View.valueOf(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле view!"); flag=true;}}
            }
        
        flag = true;
        while (flag)
        {
            System.out.println("Введите transport(FEW,NONE,LITTLE,NORMAL,ENOUGH): ");
            input = scanner.nextLine();
            if (transport==null || input.trim().isEmpty()){transport = null;break;}
            try{transport= Transport.valueOf(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле transport!"); flag=true;}
        }
        flag = true;
        String houseName="";long year=0;Integer numberOfLifts=0;
        System.out.println("Ввод house");
        
        while (flag)
        {
            System.out.println("Введите name: ");
            input = scanner.nextLine();
            if (input==null || input.trim().isEmpty()){name = null;break;}
            if (input.isEmpty()){houseName = null;}else{
            try{houseName = input;flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле name(House)!"); flag=true;}}
        }
        flag = true;
        
        while(flag)
        {
            System.out.println("Введите year: ");
            input = scanner.nextLine();
            try{year = Long.parseLong(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле year!"); flag=true;}
            if (year<=0){System.out.println("Ошибка! Значение поля year должно быть больше 0");flag=true;}
        }
        flag = true;
        while(flag)
        {
            System.out.println("Введите numberOfLifts: ");
            input = scanner.nextLine();
            try{numberOfLifts = Integer.parseInt(input);flag=false;} catch(Exception e){System.out.println("Ошибка! Значение не может быть загружено в поле numberOfLifts!"); flag=true;}
            if (numberOfLifts<=0){System.out.println("Ошибка! Значение поля  numberOfLifts должно быть больше 0"); flag=true;}
        }
        Flat flat = new Flat(name,new Coordinates(x,y), area, numberOfRooms,numberOfBathrooms,view,transport,new House(houseName,year,numberOfLifts));
        System.out.println(flat);
        return flat;
    }

        


  
}