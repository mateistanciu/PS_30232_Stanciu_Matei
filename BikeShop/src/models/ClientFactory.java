package models;

public class ClientFactory {
	
	public Account createAccount(String firstName,String lastName,String email,String username,String password, String role){
		Factory fac = new Factory();
		return fac.createAccount(firstName, lastName, email, username, password, role);
	}	
}
