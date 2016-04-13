package business;

import java.util.List;


import Models.Show;
import data.ShowDAO;

public class ShowManager {
	
	public List<Show> getShowDao() {
		ShowDAO sh = new ShowDAO();
		return sh.getShows();

	}
	public List<Show> seeShows() {
		ShowDAO sh = new ShowDAO();
		return sh.SeeShows();

	}
	
public void addShow(String title, String directed, String distribution,
		String premiereDate, int ticketsNumber){
		
		Show sh = new Show(title, directed, distribution, premiereDate, ticketsNumber);
		ShowDAO show=new ShowDAO();
		show.insertShow(sh);
		
	}
public void updateShows(String title, String directed, String distribution,
		String premiereDate, int ticketsNumber){
	Show sh = new Show(title, directed, distribution, premiereDate, ticketsNumber);
	ShowDAO show = new ShowDAO();
	show.updateShow(sh);
}
public void deleteShow(String title){
	Show sh = new Show(title);
	ShowDAO show = new ShowDAO();
	show.deleteShow(sh);
}

public int getTicketsNumber(String title){
	ShowDAO show = new ShowDAO();
	return show.getTicketsNumber(title);
}

public void updateShowList(String title){
	Show sh = new Show(title);
	ShowDAO show = new ShowDAO();
	show.updateShow(sh);
}
}
