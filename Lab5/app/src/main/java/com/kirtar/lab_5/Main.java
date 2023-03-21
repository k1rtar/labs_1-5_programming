package com.kirtar.lab_5;

import java.util.Objects;
import java.io.*;
import java.util.Queue;
import java.util.PriorityQueue;
import java.time.ZonedDateTime;
import java.util.Scanner;

import com.kirtar.lab_5.commands.*;
import com.kirtar.lab_5.commands.concrete.*;
import com.kirtar.lab_5.models.*;
import com.kirtar.lab_5.iomanagers.*;


public class Main
{
    public static void main(String[] args)
    {
        // можно объединить с коллекцией из файла Queue<Flat> collection = new PriorityQueue<Flat>();
        Scanner scanner = new Scanner(System.in);
        InputFileManager inpman = new InputFileManager();
        InputConsoleManager runner = new InputConsoleManager();
        runner.run(scanner,inpman.XMLtoFlat(args[0]));

    }
}