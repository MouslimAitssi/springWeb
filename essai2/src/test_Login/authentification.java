package test_Login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import managedBeans.LoginController;

class authentification {

	@Test
	 public void testAuthentificationValide(){
		LoginController lg = new LoginController("hamza","hamza");
		String st = lg.authenticateUser();
		assertEquals("SUCCESS", st);
	}
	
	@Test
	 public void testAuthentificationInValide(){
		LoginController lg = new LoginController("123","123");
		String st = lg.authenticateUser();
		assertEquals("FAILURE", st);
		}

}
