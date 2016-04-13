package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Show;
import Models.Ticket;

public class TicketDAO {
		private Connection con;
		private Statement st;
		private ResultSet rs;
		public void InsertTicket(Ticket ticket){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
				st = con.createStatement();
				String show = ticket.getShow();
				int row = ticket.getRow();
				int ticketNumber=ticket.getNumber();
				ShowDAO sh =new ShowDAO();
				st.execute("INSERT INTO theatre.tickets (shows, row, number, show_id) VALUES ('"+show+"', '"+row+"', '"+ticketNumber+"', '"+sh.getShowId(show)+"')");
				st.close();
			}catch(Exception ex){
				ex.printStackTrace();}
			}
		
		public boolean checkTicket(String title, int row, int number){
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
				st = con.createStatement();
				
				rs=st.executeQuery(" SELECT * FROM theatre.tickets where shows = '" + title + "';");
			
				while(rs.next())
			{
					if(rs.getInt("row") == row || rs.getInt("number") ==number)
					return false;
			}
			}catch(Exception e){
				e.printStackTrace();
			}	
			return true;
		}
		public List<Show> getShows(){
			ArrayList<Show>show = new ArrayList<Show>();
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
					st = con.createStatement();
					rs = st.executeQuery("SELECT * FROM tickets");
					while(rs.next()){
						Show sh = new Show(rs.getString("shows"));
						show.add(sh);
					}
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			return show;
			}
		
		public List<Ticket> selectTicket(Ticket ticket){
			ArrayList<Ticket> tic = new ArrayList<Ticket>();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
				st = con.createStatement();
				String show = ticket.getShow();
				rs=st.executeQuery("SELECT * from tickets WHERE shows = '"+ show +"';");
				while(rs.next()){
					Ticket t = new Ticket(rs.getString("shows"),Integer.parseInt(rs.getString("row")),Integer.parseInt(rs.getString("number")));
					tic.add(t);
				}
				rs.close();
				st.close();
			}catch(Exception ex){
				ex.printStackTrace();
				}
			return tic;
			}
		public void updateTicketsNumber(String title, int ticketsNumber){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre","root","");
				st = con.createStatement();
				st.executeUpdate("Update theatre.shows SET ticketsNumber= "+ticketsNumber+ " where title='"+ title +"';");
				st.close();
			}catch(Exception ex){
				ex.printStackTrace();
				}
		}
		
		
		}
