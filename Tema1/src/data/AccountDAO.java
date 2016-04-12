package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Account;

public class AccountDAO {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
public List<Account> getAccount(){
	ArrayList<Account> account = new ArrayList<Account>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user");
			while(rs.next()){
				Account account1 = new Account(rs.getString("name"),rs.getString("username"),rs.getString("password"),rs.getString("UserType"));
				account.add(account1);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	return account;
	}
public void AddAccount(Account acc){
	 	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
		
		st = con.createStatement();
		String name = acc.getName();
		String username = acc.getUserName();
		String password=acc.getPasswprd();
		String usertype = acc.getUserType();
		st.execute("INSERT INTO theatre.user (name, username, password, usertype) VALUES ('"+name+"', '"+ username+"','"+password+"', '"+usertype+"');");
		st.close();
	}catch(Exception ex){
		ex.printStackTrace();}

}
}
