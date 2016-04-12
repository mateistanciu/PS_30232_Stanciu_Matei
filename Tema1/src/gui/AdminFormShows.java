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


import Models.Show;
import business.ShowManagement;



public class AdminFormShows extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton addShow=new JButton("Add Show");
	private JButton seeShows=new JButton("See Shows");
	private JButton deleteShow=new JButton("Delete Show");
	private JButton updateList=new JButton("Update");
	
	private JComboBox<String> showsList=new JComboBox<String> (); 
	
	private DefaultTableModel model;
	
	private JLabel showTitle= new JLabel("ShowName");
	private JLabel directedBy = new JLabel("DirectedBy");
	private JLabel distribution = new JLabel("Distribution");
	private JLabel premiereDate = new JLabel("Premiere Date");
	private JLabel ticketsNumber = new JLabel("Number of Tickets");
	
	
	private JPanel mainPanel = new JPanel();
	private JPanel addPanel = new JPanel();
	private JPanel deleteShowPanel = new JPanel();
	
	private JTable table;
	private JTextField nameText = new JTextField();
	private JTextField directedText = new JTextField();
	private JTextField distributionText = new JTextField();
	private JTextField premiereText = new JTextField();
	private JTextField ticketText = new JTextField();

	
	
	public AdminFormShows()
	{
		super("Shows Management");
		setSize(1300,600);
		
/////////////////////Add Show Panel/////////////////////
		
		addPanel.setLayout(null);
		addPanel.setBounds(10, 10, 320, 360);
		addPanel.setBorder(BorderFactory.createTitledBorder("Add Show"));
		
		showTitle.setBounds(20, 50, 70, 30);
		addPanel.add(showTitle);
		nameText.setBounds(150,55,150,20);
		addPanel.add(nameText);
		
		directedBy.setBounds(20, 100, 70, 30);
		addPanel.add(directedBy);
		directedText.setBounds(150,100,150,20);
		addPanel.add(directedText);
		
		distribution.setBounds(20, 150, 70, 30);
		addPanel.add(distribution);
		distributionText.setBounds(150,155,150,20);
		addPanel.add(distributionText);
		
		premiereDate.setBounds(20, 200, 150, 30);
		addPanel.add(premiereDate);
		premiereText.setBounds(150,205,150,20);
		addPanel.add(premiereText);
		
		ticketsNumber.setBounds(20, 250, 150, 30);
		addPanel.add(ticketsNumber);
		ticketText.setBounds(150,255,150,20);
		addPanel.add(ticketText);
		
		addShow.setBounds(60, 300, 150, 30);
		addPanel.add(addShow);
		addShow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ShowManagement show = new ShowManagement();	
					show.AddShow((String)nameText.getText(), (String)directedText.getText(), (String)distributionText.getText(),
							premiereText.getText(),Integer.parseInt(ticketText.getText()));
					nameText.setText("");
					directedText.setText("");
					distributionText.setText("");
					premiereText.setText("");
					ticketText.setText("");
			}
			
		});
		
		
	
		
/////////////////////See Shows Panel/////////////////////
		
		seeShows.setBounds(500,10,300,20);
		mainPanel.add(seeShows);
		seeShows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
					Object data[][]={};
					Object columnNames[] = {"Title", "Directed By" , "Distribution", "Premiere Date","Tickets Number" };  
					
					model =new DefaultTableModel(data,columnNames);
					table=new JTable(model);
					table.setEnabled(false);
					table.getTableHeader().setReorderingAllowed(false);
					table.getTableHeader().setResizingAllowed(false);
					model.fireTableDataChanged();
					ShowManagement sh = new ShowManagement();
					for(Show temp:sh.seeShows()){	
					model.addRow(new Object[]{temp.getShowTitle(), temp.getDirectedBy(),temp.getDistribution(),temp.getPremiereDate(),temp.getTicketsNumber()});
					}
				    JScrollPane scrollPane = new JScrollPane(table);
				    scrollPane.setBounds(350, 40, 600, 350);
				    scrollPane.setEnabled(false);

				    mainPanel.add(scrollPane);

		    }
		
			
				
			
	    }); 
/////////////////////Update Show Panel/////////////////////
		updateList.setBounds(30, 40, 250,20);
		deleteShowPanel.add(updateList);
		updateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				showsList.removeAllItems();
				ShowManagement show = new ShowManagement();
				for(Show temp:show.getShowDao()){
					
					showsList.addItem(temp.getShowTitle());
				}
				deleteShow.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						show.DeleteShow((String) showsList.getSelectedItem());
					}
					
				});
			}
		});
		deleteShowPanel.setLayout(null);
		deleteShowPanel.setBounds(970, 10, 300, 200);
		deleteShowPanel.setBorder(BorderFactory.createTitledBorder("Delete Show"));
		
		showsList.setBounds(30, 90, 250,20);
		deleteShowPanel.add(showsList);
		
		deleteShow.setBounds(30, 150, 250,20);
		deleteShowPanel.add(deleteShow);
		
		mainPanel.add(deleteShowPanel);
		mainPanel.setLayout(null);
		
		
		
		this.add(addPanel);
		this.add(deleteShowPanel);
		this.add(mainPanel);
		
		this.setResizable(false);	
					
	}
	
}
