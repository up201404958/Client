import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import dkeep.gui.Main;

public class GUITest {

	/**
	 * Test method for Window changing, go to Login Page then go to homepage and check if homepage is visible and login page is not visible
	 * @throws IOException 
	 */
	@Test
	public void testChangeWindow() throws IOException {
		Main test = new Main();
		String[] args = null;
		Main.main(args);
		test.goToLogin();
		test.goToHomepage();
		assertTrue(test.getHomepage().isVisible());
		assertFalse(test.getLogin().isVisible());
		
	}

}
