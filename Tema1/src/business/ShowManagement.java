package business;

import java.util.List;


import Models.Show;
import data.ShowDAO;

public class ShowManagement {
	
	public List<Show> getShowDao() {
		ShowDAO sh = new ShowDAO();
		return sh.getShows();

	}
	public List<Show> seeShows() {
		ShowDAO sh = new ShowDAO();
		return sh.SeeShows();

	}
	
public void AddShow(String title, String directed, String distribution,
		String string, int ticketsNumber){
		
		Show sh = new Show(title, directed, distribution, string, ticketsNumber);
		ShowDAO show=new ShowDAO();
		show.insertShow(sh);
		
	}
public void DeleteShow(String title){
	Show sh = new Show(title);
	ShowDAO show = new ShowDAO();
	show.deleteShow(sh);
}
public void UpdateShow(String title){
	Show sh = new Show(title);
	ShowDAO show = new ShowDAO();
	show.updateShow(sh);
}
}
