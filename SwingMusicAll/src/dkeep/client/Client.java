package dkeep.client;

import java.io.*;
import java.net.*;

public class Client{
    
	Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    
    public Client(){}
    public void run(String msg)
    {
        try{
            //1. creating a socket to connect to the server
            requestSocket = new Socket("localhost", 8080);
            System.out.println("Connected to localhost in port 8080");
            //2. get Input and Output streams
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            //3: Communicating with the server
            try{
            	    sendMessage(msg);
                message = (String)in.readObject();
                System.out.println("server>" + message);
                if(message.equals("INVALID LOGIN") || message.equals("USERNAME ALREADY EXISTS"))
                		System.out.println("ERROR:" + message);
                else
                		System.out.println("server>" + message);
            
            }catch(ClassNotFoundException classNot){
                System.err.println("data received in unknown format");
            }
         
        }
        catch(UnknownHostException unknownHost){
            System.err.println("You are trying to connect to an unknown host!");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                requestSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    public void sendMessage(String msg)
    {
        try{
            out.writeObject(msg);
            out.flush();
            System.out.println("client>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
  
}