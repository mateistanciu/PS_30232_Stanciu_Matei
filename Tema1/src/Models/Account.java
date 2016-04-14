package Models;

public class Account {
private String name;
private String userName;
private String password;
private String userType;
	
public Account(String name, String userName, String password, String userType){
	
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.userType=userType;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getUserType(){
		return userType;
	}
	
	public void setUserType(String userType){
		this.userType=userType;
	}
}
