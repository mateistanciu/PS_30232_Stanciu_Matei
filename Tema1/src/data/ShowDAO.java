package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Models.Show;




public class ShowDAO {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public List<Show> SeeShows(){
		ArrayList<Show> show = new ArrayList<Show>();
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre", "root", "");
			
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM shows");
			while(rs.next()){
				Show sh = new Show(rs.getString("title"),rs.getString("directedBy"),rs.getString("distribution"),
						rs.getString("premiereDate"),rs.getInt("ticketsNumber"));
				show.add(sh);
			}
			st.close();
			rs.close();
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();		
		}
		return show;
	}
	

	public List<Show> getShows(){
		ArrayList<Show> show = new ArrayList<Show>();
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM shows");
				while(rs.next()){
					Show sh = new Show(rs.getString("title"));
					show.add(sh);
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		return show;
		}
	public void insertShow(Show show){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
			st = con.createStatement();
			String title = show.getShowTitle();
			String directedBy=show.getDirectedBy();
			String distribution = show.getDistribution();
			String premiereDate=show.getPremiereDate();
			int ticketsNumber=show.getTicketsNumber();
			st.execute("INSERT INTO theatre.shows (title, directedBy, distribution, premiereDate, ticketsNumber) VALUES ('"+title+"', '"+directedBy+"', '"+distribution+
					"', '"+premiereDate+"','"+ticketsNumber+"');");
			st.close();
		}catch(Exception ex){
			ex.printStackTrace();}
	}
	public void deleteShow(Show show){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");	
			st = con.createStatement();
			String title =  show.getShowTitle();
			st.executeUpdate("delete FROM shows WHERE title ='"+ title +"';" );
			st.close();
		}catch(Exception ex){
			ex.printStackTrace();}
	}
	public void updateShow(Show show){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
			st=con.createStatement();
			String title = show.getShowTitle();
			String directedBy=show.getDirectedBy();
			String distribution = show.getDistribution();
			String premiereDate=show.getPremiereDate();
			int ticketsNumber=show.getTicketsNumber();
			rs=st.executeQuery(" SELECT * FROM theatre.shows WHERE title='"+title+"' ; ");
			rs.next();
				st.executeUpdate("Update theatre.shows SET directedBy= '"+directedBy+"', distribution= '" + distribution+"', premiereDate = '"+premiereDate+"',"+"ticketsNumber = '"+ticketsNumber+"' Where title = '"+title+"';");
			st.close();
			rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
			}
		
	}
	public int getTicketsNumber(String title){
		int ticketsNumber=0;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
				st=con.createStatement();
				rs=st.executeQuery(" SELECT * FROM theatre.shows WHERE title='"+title+"' ; ");
				while(rs.next()){
					ticketsNumber= rs.getInt("ticketsNumber");
				}
				
				st.close();
				rs.close();
			}catch(Exception ex){
			ex.printStackTrace();
			}
		return ticketsNumber;
		
	}
	public int getShowId(String title){
		int id=0;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
				st=con.createStatement();
				rs=st.executeQuery(" SELECT * FROM theatre.shows WHERE title='"+title+"' ; ");
				while(rs.next()){
					id= rs.getInt("id");
				}
				
				st.close();
				rs.close();
			}catch(Exception ex){
			ex.printStackTrace();
			}
		return id;
		
	}	
}
