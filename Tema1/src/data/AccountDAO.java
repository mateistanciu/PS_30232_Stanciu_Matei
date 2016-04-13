package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import Models.Account;

public class AccountDAO {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String userType;
	public String checkAccount(String user, String pass){
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
			st = con.createStatement();
			
			rs=st.executeQuery(" SELECT * FROM theatre.user where username = '" + user + "' and Password ='" + pass + "';");
		while(rs.next())
			if(rs.getString("username").equals(user) && rs.getString("password").equals(pass))
				{
					userType=rs.getString("userType");
				}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return userType;
	
	}
	public boolean checkUsername(String username){
		int userCheck=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
			st = con.createStatement();
			rs=st.executeQuery(" SELECT * FROM user where username = '" + username + "';");
			while(rs.next()){
				
				if(rs.getString("username").equals(username))
					userCheck=0;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(userCheck==0)
			return true;
		else return false;
		
	}
public void AddAccount(Account acc){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
		st = con.createStatement();
		String name = acc.getName();
		String username = acc.getUserName();
		String password=acc.getPassword();
		String usertype = acc.getUserType();
		st.execute("INSERT INTO theatre.user (name, username, password, usertype) VALUES ('"+name+"', '"+ username+"','"+password+"', '"+usertype+"');");
		st.close();
	}catch(Exception ex){
		ex.printStackTrace();}

}
public void updateAccount(String user, String pass){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
		st = con.createStatement();
		st.executeUpdate("UPDATE user SET password='"+pass+"' WHERE username='"+ user+"';");
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
}
