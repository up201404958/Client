package dkeep.client;

import java.io.*;
import java.net.*;

import dkeep.gui.Main;

public class Client extends Main{
    
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
            	    String[] parts = msg.split(" ");
                message = (String)in.readObject();
                System.out.println("server>" + message);
                if(message.equals("INVALID LOGIN")) 
                		System.out.println("ERROR:" + message);
                else if(message.equals("USERNAME ALREADY EXISTS")) {
                		register.Invalid_Username.setVisible(true);
                		register.Invalid_Username.setText("INVALID USERNAME");
                }
                else if(message.equals("VALID LOGIN")){
                		System.out.println("server>" + message);
                		user.setUser(parts[1]);
                		user.goToHomepage();
                }else if(message.equals("REGISTED")) {
                		user.goToLogin();
                }
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