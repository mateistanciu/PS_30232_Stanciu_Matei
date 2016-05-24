package models;

public class Bikes {

	private String name;
	private int gears;
	private float price;
	private String color;
	private String type;
	
	public Bikes(String name, int gears, float price, String color, String type)
	{
		this.name=name;
		this.gears=gears;
		this.price=price;
		this.color=color;
		this.type=type;
	}
	public Bikes(String name) {
		this.name=name; 
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getGears(){
		return gears;
	}
	public void setGears(int gears){
		this.gears=gears;
	}
	public float getPrice(){
		return price;
	}
	public void setPrice(float price){
		this.price=price;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	


}
