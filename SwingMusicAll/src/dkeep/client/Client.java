package dkeep.client;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

import dkeep.gui.Main;
import dkeep.gui.MusicThread;

public class Client extends Main{
    
	Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    ArrayList <String> array = new ArrayList<String>();
    ArrayList <String> playlists = new ArrayList<String>();
    ArrayList <String> albums = new ArrayList<String>();
    ArrayList <String> songss = new ArrayList<String>();
    public boolean playlist = false;
    public MusicThread Song;
	

    
    public Client(){}
    
    @SuppressWarnings("unchecked") // read in object
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
                
            	    if(parts[0].equals("ARTS")) {
            	    		//server response
                		array = (ArrayList<String>)in.readObject();
                		//ListWorking//testing Jtable
                		for(int i=0;i<array.size();i++) {
                			String[] this_row = array.get(i).split(",");
                			Object[] row = {this_row[0],this_row[1],this_row[2]};
                			artists.tableModel.addRow(row);
                		}
                		System.out.println("server sent>" + array);
            	    }else if(parts[0].equals("ALBS")) {
            	    		albums = (ArrayList<String>)in.readObject();
            	    		for(int i=0;i<albums.size();i++) {
                    			String[] this_row = albums.get(i).split(",");
                    			Object[] row = {this_row[0],this_row[1],this_row[2],this_row[3],this_row[4]};
                    			albuns.tableModel.addRow(row);
                    	}
            	    }else if(parts[0].equals("MYSNGS")) {
            	    		
            			songss = (ArrayList<String>)in.readObject();
            	    
            			for(int i=0;i<songss.size();i++) {
                			String[] this_row = songss.get(i).split(",");
                			Object[] row = {this_row[0],this_row[1],this_row[2],this_row[3],this_row[4],this_row[5],this_row[6],this_row[7]};
                			mysongs.tableModel.addRow(row);
            			}

            	    }else if(parts[0].equals("SNGS")){
            	    		
            	    		songss = (ArrayList<String>)in.readObject();
            	    		
            	    		for(int i=0;i<songss.size();i++) {
                    			String[] this_row = songss.get(i).split(",");
                    			Object[] row = {this_row[0],this_row[1],this_row[2],this_row[3],this_row[4],this_row[5],this_row[6],this_row[7]};
                    			songs.tableModel.addRow(row);
                    	}
            	    
            	    }else if(parts[0].equals("SNGPLST")) {
            	    		
            	    	    ArrayList <String> playlists = (ArrayList<String>)in.readObject();
            	    	    
            	    	    mysongs.combobox = new JComboBox<String>();
            	    		mysongs.plColumn = mysongs.table.getColumnModel().getColumn(8);
            	    		
            	    		for(int i=0;i<playlists.size();i++) {
            	    			String[] this_row = playlists.get(i).split(",");
            	    			mysongs.combobox.addItem(this_row[1]+"-"+this_row[0]);
            	    		}
            	    		if(playlists.size()==0)
            	    			user.playlist=true;
            	    		mysongs.plColumn.setCellEditor(new DefaultCellEditor(mysongs.combobox));
            	    	
            	    }else if(parts[0].equals("CREATE")) { //CREATE PLAYLIST
                	
                		message = (String)in.readObject();
                		System.out.println("server>" + message);
                
                }else if(parts[0].equals("PLAYLST")) { //GET ALL PLAYLISTS FROM USER
                		
                		playlists = (ArrayList<String>)in.readObject();	
       
                		for(int i=0;i<playlists.size();i++) {
                			String[] this_playlist = playlists.get(i).split(",");
                			Object[] playlist = {this_playlist[0],this_playlist[1]};
                			myplaylists.tableModel.addRow(playlist);
                		}
                		System.out.println("server sent>" + playlists);
                		
                }else if(parts[0].equals("GOTOTA")) {
                		
                	ArrayList <String> album = (ArrayList<String>)in.readObject();
                		
                		for(int i=0;i<album.size();i++) {
                			String[] this_album = album.get(i).split(",");
                			Object[] song = {this_album[0],this_album[1],this_album[2],this_album[3],this_album[4],this_album[5]};
                			thisalbum.tableModel.addRow(song);
                		}
                		
                		System.out.println("server sent>" + album);
                
                }else if(parts[0].equals("PLSTSNG")||parts[0].equals("KPLSTSNG")||parts[0].equals("BPLSTSNG")) {
                		
                		ArrayList <String> songs = (ArrayList<String>)in.readObject();
                		
                		for(int i=0;i<songs.size();i++) {
                			String[] this_song = songs.get(i).split(",");
                			Object[] song = {this_song[0],this_song[1],this_song[2],this_song[3],this_song[4],this_song[5]};
                			thisplaylist.tableModel.addRow(song);
                		}
                		
                		System.out.println("server sent>" + songs);
                	
                	}else if(parts[0].equals("DWLD")) {
                		downloadSong(parts);
                	}else if(parts[0].equals("CHNGPASS")) {
                		logged.setText("");
                	}else{
                		message = (String)in.readObject();
                
                		if(message.equals("INVALID LOGIN")) 
                			System.out.println("ERROR:" + message);
                		else if(message.equals("USERNAME ALREADY EXISTS")) {
                			//register.Invalid_Username.setVisible(true);
                			register.label.setText("INVALID USERNAME");
                		}
                		else if(message.equals("VALID LOGIN")){
                			System.out.println("server>" + message);
                			user.setUser(parts[1]);
                			user.goToHomepage();
                		}
                		else if(message.equals("REGISTED")) {
                			user.goToLogin();
                		}
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
   
    private void downloadSong(String[] parts) {
    		
    	 	try {
    	 		byte data[] = new byte[2048]; // Here you can increase the size also which will receive it faster
	        String path = "music/music_" + parts[1]+".wav";
	    		FileOutputStream fileOut = new FileOutputStream(path);
	     
	        BufferedOutputStream fileBuffer = new BufferedOutputStream(fileOut);
	        int count;
	        int sum = 0;
	        while ((count = in.read(data)) > 0) {
	            sum += count;
	            fileBuffer.write(data, 0, count);
	            //System.out.println("Data received : " + sum);
	            fileBuffer.flush();
	        }
	        System.out.println("File Received..." + sum + " bytes");
	        fileBuffer.close();
	        in.close();
    	 	} catch (Exception e) {
    	        System.out.println("Error : " + e.toString());
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