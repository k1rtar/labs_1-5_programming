package com.kirtar.lab_5.models;

import java.util.Objects;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import com.fasterxml.jackson.annotation.JsonProperty;  
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.datatype.jsr310.*;
import com.kirtar.lab_5.models.IdFlat;

public class Flat implements Comparable<Flat>
{
    
    private Long id = ++IdFlat.lastId; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @JsonProperty("name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonProperty("Coordinates")
    private Coordinates coordinates; //Поле не может быть null
    LocalDateTime myLocalDateTime = LocalDateTime.of(2023, Month.MARCH, 1, 20, 55, 30);
    ZoneId vnZoneId = ZoneId.of("Europe/Moscow");
    private ZonedDateTime creationDate =  ZonedDateTime.of(myLocalDateTime, vnZoneId); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @JsonProperty("area")
    private double area; //Значение поля должно быть больше 0
    @JsonProperty("numberOfRooms")
    private int numberOfRooms; //Значение поля должно быть больше 0
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private long numberOfBathrooms; //Значение поля должно быть больше 0
    @JsonProperty("view")
    private View view; //Поле может быть null
    @JsonProperty("transport")
    private Transport transport; //Поле не может быть null
    @JsonProperty("house")
    private House house; //Поле не может быть null

    public Flat()
    {
        super();
    }
    public Flat(String name, Coordinates coordinates,
    double area, int numberOfRooms, long numberOfBathrooms, View view, Transport transport, House house,ZonedDateTime creationDate)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.view = view;
        this.transport = transport;
        this.house = house;
        this.creationDate = creationDate;
    }

    public Flat(String name, Coordinates coordinates,
    double area, int numberOfRooms, long numberOfBathrooms, View view, Transport transport, House house)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.view = view;
        this.transport = transport;
        this.house = house;
        /*if (id!=null){this.id = id;} else{this.id=1L;}
        if(!name.equals("") || name!=null){this.name = name;} else{this.name="DefaultFlat";}
        if (coordinates != null && coordinates.getX()>-232 &&
         coordinates.getY()>-150){this.coordinates = coordinates;} 
         else {this.coordinates = new Coordinates(1,1);}
        if(area>0){this.area = area;} else {this.area=1;}
        if (numberOfRooms>0){this.numberOfRooms = numberOfRooms;} else{this.numberOfRooms=1;}
        if (numberOfBathrooms>0){this.numberOfBathrooms = numberOfBathrooms;} else{this.numberOfBathrooms=1;}
        if (view!=null){this.view = view;} else {this.view = View.NORMAL;}
        if (transport!=null){this.transport=transport;} else {this.transport = Transport.NORMAL;}
        if (house!=null){this.house=house;} else {this.house=new House("DefaultHouse",1L,1);}*/
    }
    public Long getId() 
    {
        return id; 
    }
    public String getName()
    {
        return name;
    }
    public Coordinates getCoordinates() 
    {
        return coordinates;
    }
    public ZonedDateTime getCreationDate()
    {
        return creationDate;
    }

    public double getArea()
    {
        return area;
    }

    public int getNumberOfRooms()
    {
        return numberOfRooms;
    }

    public long getNumberOfBathrooms()
    {
        return numberOfBathrooms;
    }
    public View getView()
    {
        return view;
    }
    
    public Transport getTransport()
    {
        return transport;
    }

    public House getHouse()
    {
        return house;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) 
    {
        this.coordinates = coordinates;
    }
    public void setCreationDate(ZonedDateTime creationDate)
    {
        this.creationDate = creationDate;
    }

    public void setArea(double area)
    {
        this.area = area;
    }

    public void setNumberOfRooms(int numberOfRooms)
    {
        this.numberOfRooms = numberOfRooms;
    }

    public void setNumberOfBathrooms(long numberOfBathrooms)
    {
        this.numberOfBathrooms = numberOfBathrooms;
    }
    public void setView(View view)
    {
        this.view = view;
    }
    
    public void setTransport(Transport transport)
    {
        this.transport = transport;
    }

    public void setHouse(House house)
    {
        this.house = house;
    }

    @Override
    public int compareTo(Flat flat)
    {
        return id.compareTo(flat.getId());
    }

    @Override 
    public String toString()
    {
    	return String.format("Flat(id=%d,name=%s,coordinates=%s)",id,name,coordinates.toString());
    }


}