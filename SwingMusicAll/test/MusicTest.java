import static org.junit.Assert.*;

import org.junit.Test;
import dkeep.gui.MusicThread;



/**
 * 
 */

/**
 * 
 *
 */
public class MusicTest {

	
	/**
	 * Test method for MusicThread, plays a test file and check if the thread is running
	 */
	@Test
	public void testMusicThread() {
		MusicThread Song = new MusicThread("teste");
		Song.start();
		assertTrue(Song.isAlive());
	}
}
