
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import dkeep.client.Client;
import dkeep.gui.Main;

public class ConnectionTest {

	/**
	 * Test method for checking if connection between server and client is working
	 * @throws IOException 
	 *  
	 */
	@Test
	public void testRun() throws IOException {
		Main.main(null);
		Client user = new Client();
		user.run("LOGN User wer");
		String ret = user.getMessage();
		assertEquals(ret,"VALID LOGIN");
		
	}

}
