package dkeep.client;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

import dkeep.gui.Main;
import dkeep.gui.MusicThread;

/**
 * This class represents the client part of the application
 * In this class we make the requests to the server and interpret the answers
 *
 */
public class Client extends Main{
    
	private Socket requestSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	protected String message;
    private boolean playlist;
    protected MusicThread Song;

    /**
     * This method is the main method of the class, and every request goes through here
     * The protocol used to communicate is a custom protocol 
     * @param msg to be sent to the server
     */
    @SuppressWarnings("unchecked") // read in object
	public void run(String msg){
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
   
            	    		ArrayList <String> array = (ArrayList<String>)in.readObject();
                		
                		for(int i=0;i<array.size();i++) {
                			String[] this_row = array.get(i).split(",");
                			Object[] row = {this_row[0],this_row[1],this_row[2]};
                			artists.getTableModel().addRow(row);
                		}
                		System.out.println("server sent>" + array);
            	    }else if(parts[0].equals("ALBS")) {
            	    		ArrayList <String> albums = (ArrayList<String>)in.readObject();
            	    		for(int i=0;i<albums.size();i++) {
                    			String[] this_row = albums.get(i).split(",");
                    			Object[] row = {this_row[0],this_row[1],this_row[2],this_row[3],this_row[4]};
                    			albuns.getTableModel().addRow(row);
                    	}
            	    }else if(parts[0].equals("MYSNGS")) {
            	    		
            	    		ArrayList <String> songss = (ArrayList<String>)in.readObject();
            	    
            			for(int i=0;i<songss.size();i++) {
                			String[] this_row = songss.get(i).split(",");
                			Object[] row = {this_row[0],this_row[1],this_row[2],this_row[3],this_row[4],this_row[5],this_row[6],this_row[7]};
                			mysongs.getTableModel().addRow(row);
            			}

            	    }else if(parts[0].equals("SNGS")){
            	    		
            	    		ArrayList <String> songss = (ArrayList<String>)in.readObject();
            	    		
            	    		for(int i=0;i<songss.size();i++) {
                    			String[] this_row = songss.get(i).split(",");
                    			Object[] row = {this_row[0],this_row[1],this_row[2],this_row[3],this_row[4],this_row[5],this_row[6],this_row[7]};
                    			songs.getTableModel().addRow(row);
                    	}
            	    
            	    }else if(parts[0].equals("SNGPLST")) {
            	    		
            	    	    ArrayList <String> playlists = (ArrayList<String>)in.readObject();
            	    	    
            	    	    mysongs.setCombobox(new JComboBox<String>());
            	    		mysongs.setPlColumn(mysongs.table.getColumnModel().getColumn(8));
            	    		
            	    		for(int i=0;i<playlists.size();i++) {
            	    			String[] this_row = playlists.get(i).split(",");
            	    			mysongs.getCombobox().addItem(this_row[1]+"-"+this_row[0]);
            	    		}
            	    		if(playlists.size()>0)
            	    			user.setPlaylist(true);
            	    		
            	    		mysongs.getPlColumn().setCellEditor(new DefaultCellEditor(mysongs.getCombobox()));
            	    	
            	    }else if(parts[0].equals("CREATE")) { //CREATE PLAYLIST
                	
                		message = (String)in.readObject();
                		System.out.println("server>" + message);
                
                }else if(parts[0].equals("PLAYLST")) { //GET ALL PLAYLISTS FROM USER
                		
                		ArrayList <String> playlists = (ArrayList<String>)in.readObject();	
       
                		for(int i=0;i<playlists.size();i++) {
                			String[] this_playlist = playlists.get(i).split(",");
                			Object[] playlist = {this_playlist[0],this_playlist[1]};
                			myplaylists.getTableModel().addRow(playlist);
                		}
                		System.out.println("server sent>" + playlists);
                		
                }else if(parts[0].equals("GOTOTA")) {
                		
                		ArrayList <String> album = (ArrayList<String>)in.readObject();
                		
                		for(int i=0;i<album.size();i++) {
                			String[] this_album = album.get(i).split(",");
                			Object[] song = {this_album[0],this_album[1],this_album[2],this_album[3],this_album[4],this_album[5]};
                			thisalbum.getTableModel().addRow(song);
                		}
                		
                		System.out.println("server sent>" + album);
                
                }else if(parts[0].equals("PLSTSNG")||parts[0].equals("KPLSTSNG")||parts[0].equals("BPLSTSNG")) {
                		
                		ArrayList <String> songs = (ArrayList<String>)in.readObject();
                		
                		for(int i=0;i<songs.size();i++) {
                			String[] this_song = songs.get(i).split(",");
                			Object[] song = {this_song[0],this_song[1],this_song[2],this_song[3],this_song[4],this_song[5]};
                			thisplaylist.getTableModel().addRow(song);
                		}
                		
                		System.out.println("server sent>" + songs);
                	
                	}else if(parts[0].equals("DWLD")) {
                		downloadSong(parts);
                	}else if(parts[0].equals("CHNGPASS")) {
                		logged.setText("");
                	}else if(parts[0].equals("ADDSNG")){
                		System.out.println("ADDED SONG");
                	}
                	else{
                		message = (String)in.readObject();
                
                		if(message.equals("INVALID LOGIN")) {
                			System.out.println("ERROR:" + message);
                			notlogged.getLblNewLabel().setText("INVALID LOGIN");
                		}else if(message.equals("USERNAME ALREADY EXISTS")) {
                			//register.Invalid_Username.setVisible(true);
                			register.getLabel().setText("INVALID USERNAME");
                		}else if(message.equals("VALID LOGIN")){
                			System.out.println("server>" + message);
                			user.setUser(parts[1]);
                			user.goToHomepage();
                		}else if(message.equals("REGISTED")) {
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
   
    /**
     * This method is used for receiving a music from the server using sockets
     * @param parts used for saving the music with an adequate name
     */
    private void downloadSong(String[] parts) {
    		
    	 	try {
    	 		byte data[] = new byte[4096]; // Here you can increase the size also which will receive it faster
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

	/**
	 * This method sends the request  through a socket
	 * @param msg to be sent to the the server
	 */
	private void sendMessage(String msg){
        try{
            out.writeObject(msg);
            out.flush();
            System.out.println("client>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
	public String getMessage() {
		return this.message;
	}

	public boolean hasPlaylist() {
		return playlist;
	}

	public void setPlaylist(boolean playlist) {
		this.playlist = playlist;
	}
   
  
}