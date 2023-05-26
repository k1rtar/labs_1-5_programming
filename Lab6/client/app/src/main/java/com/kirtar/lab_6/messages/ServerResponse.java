package com.kirtar.lab_6.messages;

import java.io.Serializable;

/**
 * A class that returns a response from the server to the client
 */
public class ServerResponse implements Serializable{
    public ResultStatus status;
    public String message;
    public ServerResponse(ResultStatus status,String message)
    {
        this.status = status;
        this.message = message;
    }
}

