package Models;

public class Ticket {
private String show;
private int row;
private int number;

	public Ticket(String show, int row, int number){
		this.show=show;
		this.row=row;
		this.number=number;
	}
	
	public Ticket(String show)
	{
		this.show=show;
	}
	
	public void setShow(String show){
		this.show=show;	
	}
	
	public String getShow(){
		return show;
	}
	
	public void setRow(int row){
		this.row=row;
	}
	
	public int getRow(){
		return row;
	}
	
	public void setNumber(int number){
		this.number=number;
	}
	
	public int getNumber(){
		return number;
	}
}
