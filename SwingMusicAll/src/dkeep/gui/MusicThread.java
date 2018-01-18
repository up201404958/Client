package dkeep.gui;

import java.io.File;
import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;

public class MusicThread extends Thread {
		
		@Override
		 public void run(){
		//	while(true) {
			Flags.activethread=true;
			TinySound.init();
			Music song = TinySound.loadMusic(new File( "test2.wav"));
			song.play(false);
			while (song.playing()== true)
			{
				//if (song.playing()==false || Flags.flag==false )break;		
				if (Flags.flag==false )break;	
				
				if(Flags.stoped==true)
				{

					
					song.pause();
					
					while(true)
					{System.out.println("Hello");
						
						if(Flags.stoped==false) {
							song.resume();
							break;
						}
						
					}
						
				}
			
				
			}
			System.out.println("Hshuttto");
			TinySound.shutdown();
	      
	   // }
			}
}

