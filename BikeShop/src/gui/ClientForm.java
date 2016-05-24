package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business.BikesManager;
import models.Bikes;

public class ClientForm extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton seeBikes=new JButton("See Bikes");
	private JButton updateList=new JButton("Update");
	private JButton buy = new JButton("Buy Bike");
	private JComboBox<String> bikesList=new JComboBox<String> (); 
	
	private DefaultTableModel model;
	
	
	
	
	private JPanel mainPanel = new JPanel();
	
	
	private JTable table;
	
	
	
	public ClientForm()
	{
		super("Bikes Manager");
		
		setSize(1000,500);
		
		
		

		
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

		updateList.setBounds(30, 40, 250,20);
		updateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				bikesList.removeAllItems();
				BikesManager bike = new BikesManager();
				for(Bikes temp:bike.getBikesDao()){
					
					bikesList.addItem(temp.getName());
				}	
			}
		});
		
		
		bikesList.setBounds(30, 90, 250,20);
		mainPanel.add(bikesList);
		mainPanel.add(updateList);
		buy.setBounds(30,130,250,20);
		mainPanel.add(buy);
		mainPanel.setLayout(null);
		buy.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
				.showMessageDialog(
						null,
						"Congratiulations, you bought a Bike",
						"Successfully Buy", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		this.add(mainPanel);
		
		this.setResizable(false);	
					
	}
	
}
