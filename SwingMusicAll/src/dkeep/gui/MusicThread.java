package dkeep.gui;

import java.io.File;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;

/**
 * This class represents the Thread that is created to play the music when such is required
 * It uses an external library (TinySound) that simplifies a lot of the process
 *
 */
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
			boolean pause_stop = false;
			try {
				sleep(3000); //loading purposes 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			song.play(false);
			System.out.println("playing");
			while (song.playing()){
				if (!Flags.flag==false)
					break;	

				while(Flags.stoped) {
					song.pause();
					if(!Flags.flag) {
						pause_stop=true;
						break;
					}
				}
				if(pause_stop)
					break;
				song.resume();
			
			}
			System.out.println("stopped");
			song.stop();
			Flags.activethread=false;
			TinySound.shutdown();
	      }
}

