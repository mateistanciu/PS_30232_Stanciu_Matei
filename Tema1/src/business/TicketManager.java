package business;

import java.util.List;

import Models.Ticket;
import data.TicketDAO;

public class TicketManager {

	public void addTicket(String show, int row, int number ){
		Ticket ticket = new Ticket(show, row, number );
		TicketDAO t= new TicketDAO();
		t.InsertTicket(ticket);
	}
	public List<Ticket> selectTicket(String show){
		Ticket ticket = new Ticket(show);
		TicketDAO t= new TicketDAO();
		return t.selectTicket(ticket);
	}
	public void updateTicketsList(String title, int ticketsNumber){
		TicketDAO t= new TicketDAO();
		t.updateTicketsNumber(title, ticketsNumber);
	}
public boolean checkTicket(String title, int row, int number) {
		
		TicketDAO ticket = new TicketDAO();
		if(ticket.checkTicket(title, row,number))
			return true;
		else return false;
	}
}
