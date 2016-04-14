package Models;


public class Show {

	private String showTitle;
	private String directedBy;
	private String distribution;
	private String premiereDate;
	private int ticketsNumber;
	
	public Show(String showTitle,String directedBy,String distribution,
			String premiereDate,int ticketsNumber ){
		
		this.showTitle=showTitle;
		this.directedBy=directedBy;
		this.distribution=distribution;
		this.premiereDate=premiereDate;
		this.ticketsNumber =ticketsNumber;
	}
	
	public Show(String title) {
		this.showTitle=title;
	}
	
	public String getShowTitle(){
		return showTitle;
	}
	public void setShowTitle(String showTitle){
		this.showTitle=showTitle;
	}
	
	public String getDirectedBy(){
		return directedBy;
	}
	
	public void setDirectedBy(String directedBy){
		this.directedBy=directedBy;
	}
	
	public String getDistribution(){
		return distribution;	
	}
	
	public void setDistribution(String distribution){
		this.distribution=distribution;
	}
	
	public String getPremiereDate(){
		return premiereDate;
	}
	
	public void setPremiereDate(String premiereDate){
		this.premiereDate=premiereDate;
	}
	
	public int getTicketsNumber(){
		return ticketsNumber;
	}
	
	public void setTicketsNumber(int ticketsNumber){
		this.ticketsNumber=ticketsNumber;
	}
	
}
