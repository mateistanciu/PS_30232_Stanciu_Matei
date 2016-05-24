package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import models.Account;


public class AccountDAO {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	private  String url	="jdbc:mysql://localhost:3306/bikeshop";
	private String root = "root";
	private String pass ="";
	private String role;
	public AccountDAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,root,pass);
		}catch(Exception ex){
		ex.printStackTrace();}
	}
	
	public void AddAccount(Account acc){
		try{
			st = con.createStatement();
			
			String firstName = acc.getFirstName();
			String lastName = acc.getLastName();
			String email = acc.getUsername();
			String username = acc.getUsername();
			String password = acc.getPassword();
			String role = acc.getRole();
			st.execute("INSERT INTO bikeshop.account (firstname, lastname, email, username, password,role) "
					+ "VALUES ('"+firstName+"' , '"+ lastName+"','"+email+"', '"+username+"','"+password+"','"+role+"');");
		}catch(Exception ex){
			ex.printStackTrace();}

	}
	public String checkAccount(String user, String pass){
	
		try{
			st = con.createStatement();
			rs=st.executeQuery(" SELECT * FROM bikeshop.account where username = '" + user + "' and Password ='" + pass + "';");
		while(rs.next())
			if(rs.getString("username").equals(user) && rs.getString("password").equals(pass))
				{
					role=rs.getString("role");
				}	
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return role;
	}
	public boolean checkUsername(String username){
		try{
			st = con.createStatement();
			rs=st.executeQuery(" SELECT * FROM account where username = '" + username + "';");
			while(rs.next()){
				if(rs.getString("username").equals(username))
					return true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		 return false;
	}
	public void updateAccount(String user, String pass){
		try{
			st = con.createStatement();
			st.executeUpdate("UPDATE account SET password='"+pass+"' WHERE username='"+ user+"';");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
