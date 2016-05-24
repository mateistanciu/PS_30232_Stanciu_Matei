package business;

import java.util.List;

import data.BikesDAO;
import models.Bikes;




public class BikesManager {
	
	public List<Bikes> getBikesDao() {
		BikesDAO bk = new BikesDAO();
		return bk.getBikes();

	}
	public List<Bikes> seeBikes() {
		BikesDAO bk = new BikesDAO();
		return bk.SeeBikes();

	}
	
public void addBike(String name,int gears,float price,String color,String type){
		
		Bikes bk = new Bikes(name, gears, price, color, type);
		BikesDAO bike=new BikesDAO();
		bike.AddBike(bk);
		
	}
public void updateBikes(String name,int gears,float price,String color,String type){
	Bikes bk = new Bikes(name, gears, price, color, type);
	BikesDAO bike = new BikesDAO();
	bike.updateBike(bk);
}
public void deleteBike(String name){
	Bikes bk = new Bikes(name);
	BikesDAO bike = new BikesDAO();
	bike.deleteBike(bk);
}


public void updateBikeList(String name){
	Bikes bk = new Bikes(name);
	BikesDAO bike = new BikesDAO();
	bike.updateBike(bk);
}
}
