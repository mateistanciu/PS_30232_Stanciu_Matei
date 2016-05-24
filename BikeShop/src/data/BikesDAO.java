package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Bikes;




public class BikesDAO {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String url	="jdbc:mysql://localhost:3306/bikeshop";
	private String root = "root";
	private String pass ="";
	public BikesDAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,root,pass);
		   }catch(Exception ex){
		ex.printStackTrace();}
	}
	public List<Bikes> SeeBikes(){
		ArrayList<Bikes> bike = new ArrayList<Bikes>();
		try{	
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM bikes");
			while(rs.next()){
				Bikes bk = new Bikes(rs.getString("name"),rs.getInt("gears"),rs.getFloat("price"),rs.getString("color"),rs.getString("type"));;
				bike.add(bk);
			}
			st.close();
			rs.close();
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();		
		}
		return bike;
	}
	

	public List<Bikes> getBikes(){
		ArrayList<Bikes> bike = new ArrayList<Bikes>();
			
			try{
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM bikes");
				while(rs.next()){
					Bikes bk = new Bikes(rs.getString("name"));
					bike.add(bk);
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		return bike;
		}
	public void AddBike(Bikes bike){
		try{
			st = con.createStatement();
			 String name=bike.getName();
			 int gears=bike.getGears();
			 float price=bike.getPrice();
			 String color=bike.getColor();
			 String type=bike.getType();
			st.execute("INSERT INTO bikeshop.bikes (name, gears, price, color, type) VALUES ('"+name+"', '"+gears+"', '"+price+
					"', '"+color+"','"+type+"');");
			st.close();
		}catch(Exception ex){
			ex.printStackTrace();}
	}
	public void deleteBike(Bikes bike){
		try{
			st = con.createStatement();
			String name =  bike.getName();
			st.executeUpdate("delete FROM bikeshop WHERE name ='"+ name +"';" );
			st.close();
		}catch(Exception ex){
			ex.printStackTrace();}
	}
	public void updateBike(Bikes bike){
		try{
			st=con.createStatement();
			 String name=bike.getName();
			 int gears=bike.getGears();
			 float price=bike.getPrice();
			 String color=bike.getColor();
			 String type=bike.getType();
			rs=st.executeQuery(" SELECT * FROM bikeshop.bikes WHERE name='"+name+"' ; ");
			rs.next();
				st.executeUpdate("Update theatre.shows SET gears= '"+gears+"', price= '" + price+"', price = '"+color+"',"+"type = '"+type+"' Where name = '"+name+"';");
			st.close();
			rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
			}
		
	}
}
