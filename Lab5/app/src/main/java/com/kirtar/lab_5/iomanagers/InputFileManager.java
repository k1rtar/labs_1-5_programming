//чтение из файла и загрузка в коллекцию
package com.kirtar.lab_5.iomanagers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.JsonProcessingException;  
import com.fasterxml.jackson.databind.JsonMappingException; 
import com.fasterxml.jackson.databind.*; 
import com.fasterxml.jackson.datatype.jsr310.*;

import com.kirtar.lab_5.models.Flat;
import com.kirtar.lab_5.models.Coordinates;
import com.kirtar.lab_5.models.IdFlat;


public class InputFileManager
{
    public static String path;
    public PriorityQueue<Flat> XMLtoFlat(String pathValue) 
    {
        PriorityQueue<Flat> collection = new PriorityQueue<Flat>();
        try {
            path = pathValue;
            FileInputStream inputFile = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFile));
            String responsetmp = new String();
            for (String line; (line = br.readLine()) != null; responsetmp += line);
            String response = responsetmp.replaceAll(" ","");
            System.out.println(response);    
            if (responsetmp.indexOf("creationDate")!=-1)
            {
                int start = 0;
                int end = response.indexOf("</Flat>")+7;
                while (end!=-1)
                {
                    String currentSubString = response.substring(start,end);
                    response = response.substring(end,response.length());
                    start = 0;
                    end = response.indexOf("</Flat>")+7;
                    ObjectMapper xmlmapper = new XmlMapper();
                    xmlmapper.registerModule(new JavaTimeModule());
                    xmlmapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                    Flat value = xmlmapper.readValue(currentSubString,Flat.class);
                    value.setId(IdFlat.lastId); 
                    collection.add(value);
    
                } 
            }
            
            int start = 0;
            int end = response.indexOf("</Flat>")+7;
            while (end!=-1)
            {
                String currentSubString = response.substring(start,end);
                response = response.substring(end,response.length());
                start = 0;
                end = response.indexOf("</Flat>")+7;
                ObjectMapper xmlmapper = new XmlMapper();
                Flat value = xmlmapper.readValue(currentSubString,Flat.class);
                value.setId(IdFlat.lastId); 
                collection.add(value);

            } 
            
        }
        catch (StringIndexOutOfBoundsException e)
        {
        }

        catch (JsonMappingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (JsonProcessingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }   
        catch (Exception e) {
            e.printStackTrace();
            
        }
        System.out.println(collection.size());
        return collection;
    }


        
       
        
    
}