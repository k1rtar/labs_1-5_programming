package com.kirtar.lab_6.messages;

import java.io.Serializable;

/**
 * A class that makes a request to the server to execute a command with the specified arguments
 */
public class ClientRequest<T> implements Serializable{
     public String commandType;
     public T commandArgument;
     public ClientRequest(String commandType, T commandArgument)
     {
          this.commandType = commandType;
          this.commandArgument = commandArgument;
     }
}
