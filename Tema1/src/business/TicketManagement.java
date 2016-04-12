package business;

import java.util.List;

import Models.Ticket;
import data.TicketDAO;

public class TicketManagement {

	public void Ticket(String show, int row, int number ){
		Ticket ticket = new Ticket(show, row, number );
		TicketDAO t= new TicketDAO();
		t.InsertTicket(ticket);
	}
	public List<Ticket> selectTicket(String show){
		Ticket ticket = new Ticket(show);
		TicketDAO t= new TicketDAO();
		return t.selectTicket(ticket);
	}
}
