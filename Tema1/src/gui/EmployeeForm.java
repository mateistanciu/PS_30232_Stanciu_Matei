package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Models.Show;
import Models.Ticket;
import business.ShowManager;
import business.TicketManager;

public class EmployeeForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton addTicket = new JButton("Add Sold Ticket");
	private JButton upShows = new JButton("Refresh");
	
	private JButton seeTickets = new JButton("See Sold Tickets");
	private JButton seeAvailableTickets = new JButton("Available Tickets");
	
	private JComboBox <String> viewTickets = new JComboBox<String>();
	private JComboBox <String> seeShows = new JComboBox<String>();
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JLabel show = new JLabel("Show");
	private JLabel row = new JLabel("Row");
	private JLabel ticketNumber = new JLabel("Ticket Number");
	
	private JTable table = new JTable();
	private JTable table1 = new JTable();
	private JTextField rowText = new JTextField();
	private JTextField ticketText = new JTextField();
	
	private JPanel addTicketPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	public EmployeeForm()
	{
		
		super("Ticket Managemer");
		setSize(1200,450);
		
/////////////////////Add Sold Ticket Panel/////////////////////
		addTicketPanel.setLayout(null);
		addTicketPanel.setBounds(10, 10, 320, 360);
		addTicketPanel.setBorder(BorderFactory.createTitledBorder("Add Ticket"));
		
		show.setBounds(20, 20, 40, 20);
		addTicketPanel.add(show);
		seeShows.setBounds(130,25,150,20);
		addTicketPanel.add(seeShows);
		
		row.setBounds(20, 50, 40, 20);
		addTicketPanel.add(row);
		rowText.setBounds(130,55,150,20);
		addTicketPanel.add(rowText);
		
		ticketNumber.setBounds(20, 80, 90, 20);
		addTicketPanel.add(ticketNumber);
		ticketText.setBounds(130,85,150,20);
		addTicketPanel.add(ticketText);
		
		addTicket.setBounds(50, 150, 150,30);
		addTicketPanel.add(addTicket);
		
		seeAvailableTickets.setBounds(50, 200, 150, 30);
		addTicketPanel.add(seeAvailableTickets);
		addTicket.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TicketManager ticket = new TicketManager();{
					String title = (String)seeShows.getSelectedItem();
					int row = Integer.parseInt(rowText.getText());
					int number =Integer.parseInt(ticketText.getText());
					ShowManager sh = new ShowManager();
					try{
					if(sh.getTicketsNumber(title)>0 && ticket.checkTicket(title, row, number)){
						ticket.addTicket(title, row, number);
						ticket.updateTicketsList(title, sh.getTicketsNumber(title)-1);
						rowText.setText("");
						ticketText.setText("");
					}
					else{
						JOptionPane
						.showMessageDialog(
								null,
								"Not enough tickets or wrong row or number",
								"Ticket Error", JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception x){
						x.printStackTrace();	
					}
					}
				}
			});
		
/////////////////////See Available Tickets/////////////////////
		seeAvailableTickets.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent a) {
				try {
					Object data[][]={};
					Object columnNames[] = {"Show", "Available Tickets"};  
					int ticketsNumber=0;
					model1 =new DefaultTableModel(data,columnNames);
					table1=new JTable(model1);
					table1.setEnabled(false);
					table1.getTableHeader().setReorderingAllowed(false);
					table1.getTableHeader().setResizingAllowed(false);
					
					model1.fireTableDataChanged();
					ShowManager sh = new ShowManager();
					ticketsNumber=sh.getTicketsNumber((String)seeShows.getSelectedItem());
						
						model1.addRow(new Object[]{(String)seeShows.getSelectedItem(), ticketsNumber});
							
					
					
					
				    JScrollPane scrollPane = new JScrollPane(table1);
				    scrollPane.setBounds(40, 260, 250,38);
				    scrollPane.setEnabled(false);

				    addTicketPanel.add(scrollPane);
				    }
				 catch (IllegalArgumentException e1) {
					 
				 }
				
			}
			
		});
		
		
/////////////////////See Sold Tickets Panel/////////////////////
		
viewTickets.setBounds(400,10,200,20);
mainPanel.add(viewTickets);


upShows.setBounds(800,10,150,40);
mainPanel.add(upShows);
upShows.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
		viewTickets.removeAllItems();
		ShowManager show = new ShowManager();
		for(Show temp:show.getShowDao()){
			
			viewTickets.addItem(temp.getShowTitle());
			seeShows.addItem(temp.getShowTitle());
		}
		}
		
});

seeTickets.setBounds(800, 100, 150, 45);
mainPanel.add(seeTickets);
seeTickets.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
	try {
		Object data[][]={};
		Object columnNames[] = {"Show", "Row" , "Number"};  
		
		model =new DefaultTableModel(data,columnNames);
		table=new JTable(model);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		model.fireTableDataChanged();
		
		TicketManager tic = new TicketManager();
		for(Ticket temp:tic.selectTicket((String)viewTickets.getSelectedItem())){	
			model.addRow(new Object[]{temp.getShow(),temp.getRow(),temp.getNumber()});
		}		
		
		
		
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(350, 40, 400, 350);
	    scrollPane.setEnabled(false);

	    mainPanel.add(scrollPane);
	    }
	 catch (IllegalArgumentException e1) {
		 
	 }
	}
}); 
		mainPanel.add(addTicketPanel);
		mainPanel.setLayout(null);
		this.add(addTicketPanel);
		this.add(mainPanel);
	
		this.setResizable(false);	
		this.setLocation(200, 100);
	}
	
}