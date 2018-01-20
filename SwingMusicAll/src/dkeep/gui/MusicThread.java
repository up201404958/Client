package dkeep.gui;

import java.io.File;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;

public class MusicThread extends Thread {
		
		protected String id;
		
		public MusicThread(String id) {
			this.id = id;
		}
		@Override
		 public void run(){
		
			Flags.activethread=true;
			TinySound.init();
			String path = "music/music_" + this.id+".wav";
			Music song = TinySound.loadMusic(new File(path));
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			song.play(false);
			while (song.playing()== true){
				if (Flags.flag==false)
					break;	
				if(Flags.stoped==true){
					song.pause();
					while(true){
						System.out.println("Hello");
						if(Flags.stoped==false) {
							song.resume();
							break;
						}
					}
				}
			}
			
			System.out.println("Hshuttto");
			song.stop();
			Flags.activethread=false;
			TinySound.shutdown();
	      }
}

