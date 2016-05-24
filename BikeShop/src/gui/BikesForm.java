package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import business.BikesManager;
import models.Bikes;





public class BikesForm extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton addBike=new JButton("Add Bike");
	private JButton seeBikes=new JButton("See Bikes");
	private JButton deleteBike=new JButton("Delete Bike");
	private JButton updateList=new JButton("Update");
	private JButton updateBikes=new JButton("Update Bikes");
	private JButton back=new JButton("Back");
	
	private JComboBox<String> bikesList=new JComboBox<String> (); 
	
	private DefaultTableModel model;
	
	private JLabel bikeName= new JLabel("Bike Name");
	private JLabel gears = new JLabel("Gears");
	private JLabel price = new JLabel("Price");
	private JLabel color = new JLabel("Color");
	private JLabel type = new JLabel("Type");
	
	
	private JPanel mainPanel = new JPanel();
	private JPanel addPanel = new JPanel();
	private JPanel deleteBikePanel = new JPanel();
	
	private JTable table;
	private JTextField bikeNameText = new JTextField();
	private JTextField gearsText = new JTextField();
	private JTextField priceText = new JTextField();
	private JTextField colorText = new JTextField();
	private JTextField typeText = new JTextField();
	
	
	public BikesForm()
	{
		super("Bikes Manager");
		
		setSize(1300,600);
		
/////////////////////Add Bikes Panel/////////////////////
		
		addPanel.setLayout(null);
		addPanel.setBounds(10, 10, 320, 400);
		addPanel.setBorder(BorderFactory.createTitledBorder("Add Bike"));
		
		bikeName.setBounds(20, 50, 70, 30);
		addPanel.add(bikeName);
		bikeNameText.setBounds(150,55,150,20);
		addPanel.add(bikeNameText);
		
		gears.setBounds(20, 100, 70, 30);
		addPanel.add(gears);
		gearsText.setBounds(150,100,150,20);
		addPanel.add(gearsText);
		
		price.setBounds(20, 150, 70, 30);
		addPanel.add(price);
		priceText.setBounds(150,155,150,20);
		addPanel.add(priceText);
		
		color.setBounds(20, 200, 150, 30);
		addPanel.add(color);
		colorText.setBounds(150,205,150,20);
		addPanel.add(colorText);
		
		type.setBounds(20, 250, 150, 30);
		addPanel.add(type);
		typeText.setBounds(150,255,150,20);
		addPanel.add(typeText);
		
		addBike.setBounds(60, 300, 150, 30);
		addPanel.add(addBike);
		
		addBike.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					
					String bikeName = bikeNameText.getText();
					int gears = Integer.parseInt(gearsText.getText());
					
					float price = Float.parseFloat(priceText.getText());
					String color = colorText.getText();
					String type = typeText.getText();
		            BikesManager bike= new BikesManager();
		            bike.addBike(bikeName, gears , price,color,type);
					bikeNameText.setText("");
					gearsText.setText("");
					priceText.setText("");
					colorText.setText("");
					typeText.setText("");				
				}
		});
		back.setBounds(10, 450, 100, 30);
		mainPanel.add(back);
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				IntermForm form = new IntermForm();
				form.setVisible(true);
				setVisible(false);
			}
			
		});
/////////////////////Update Bikes Panel/////////////////////
		
		updateBikes.setBounds(60, 350, 150, 30);
		addPanel.add(updateBikes);
		updateBikes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					String bikeName = bikeNameText.getText();
					int gears = Integer.parseInt(gearsText.getText());
					float price = Float.parseFloat(priceText.getText());
					String color = colorText.getText();
					String type = typeText.getText();
					
					BikesManager bike = new BikesManager();
						bike.updateBikes(bikeName, gears , price,color,type);
						bikeNameText.setText("");
						gearsText.setText("");
						priceText.setText("");
						colorText.setText("");
						typeText.setText("");
			}
			
		});
		

		
/////////////////////See Bikes Panel/////////////////////
		
		seeBikes.setBounds(500,10,300,20);
		mainPanel.add(seeBikes);
		seeBikes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
					Object data[][]={};
					Object columnNames[] = {"Bike Name", "Gears" , "Color", "Type","Price" };  
					
					model =new DefaultTableModel(data,columnNames);
					table=new JTable(model);
					table.setEnabled(false);
					table.getTableHeader().setReorderingAllowed(false);
					table.getTableHeader().setResizingAllowed(false);
					model.fireTableDataChanged();
					BikesManager bk = new BikesManager();
					for(Bikes temp:bk.seeBikes()){	
					model.addRow(new Object[]{temp.getName(), temp.getGears(),temp.getColor(),temp.getType(),temp.getPrice()});
					}
				    JScrollPane scrollPane = new JScrollPane(table);
				    scrollPane.setBounds(350, 40, 600, 350);
				    scrollPane.setEnabled(false);

				    mainPanel.add(scrollPane);

		    }
		
			
				
			
	    }); 
/////////////////////Update Bikes Panel/////////////////////
		updateList.setBounds(30, 40, 250,20);
		deleteBikePanel.add(updateList);
		updateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				bikesList.removeAllItems();
				BikesManager bike = new BikesManager();
				for(Bikes temp:bike.getBikesDao()){
					
					bikesList.addItem(temp.getName());
				}
				deleteBike.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						bike.deleteBike((String) bikesList.getSelectedItem());
					}
					
				});
			}
		});
		deleteBikePanel.setLayout(null);
		deleteBikePanel.setBounds(970, 10, 300, 200);
		deleteBikePanel.setBorder(BorderFactory.createTitledBorder("Delete Bike"));
		
		bikesList.setBounds(30, 90, 250,20);
		deleteBikePanel.add(bikesList);
		
		deleteBike.setBounds(30, 150, 250,20);
		deleteBikePanel.add(deleteBike);
		
		mainPanel.add(deleteBikePanel);
		mainPanel.setLayout(null);
		
		
		
		this.add(addPanel);
		this.add(deleteBikePanel);
		this.add(mainPanel);
		
		this.setResizable(false);	
					
	}
	
}
