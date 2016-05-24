package models;

public class Factory {

	private Account account;
	
	public Account createAccount(String firstName,String lastName,String email,String username,String password, String role ){
		
		if(role.equals("admin")){
			account = new Admin(firstName, lastName, email, username, password, role);
		} 
		else if(role.equals("employee")){
			
			account=new Employee(firstName, lastName, email, username, password, role);
		}
		else if (role.equals("client")){
			account = new User(firstName, lastName, email, username, password, role);
		}
		return account;
	}
}
