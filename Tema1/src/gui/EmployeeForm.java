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
import Models.Ticket;
import business.ShowManagement;
import business.TicketManagement;

public class EmployeeForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton addTicket = new JButton("Add Sold Ticket");
	private JButton upShows = new JButton("Refresh");
	private JButton seeTickets = new JButton("See Sold Tickets");
	
	private JComboBox <String> viewTickets = new JComboBox<String>();
	private DefaultTableModel model;
	
	private JLabel show = new JLabel("Show");
	private JLabel row = new JLabel("Row");
	private JLabel ticketNumber = new JLabel("Ticket Number");
	
	private JTable table = new JTable();
	
	private JTextField showText = new JTextField();
	private JTextField rowText = new JTextField();
	private JTextField ticketText = new JTextField();
	
	private JPanel addTicketPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	
	public EmployeeForm()
	{
		super("Ticket Management");
		setSize(1200,450);
		addTicketPanel.setLayout(null);
		addTicketPanel.setBounds(10, 10, 320, 360);
		addTicketPanel.setBorder(BorderFactory.createTitledBorder("Add Ticket"));
		
		show.setBounds(20, 20, 40, 20);
		addTicketPanel.add(show);
		showText.setBounds(130,25,150,20);
		addTicketPanel.add(showText);
		
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
		addTicket.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TicketManagement ticket = new TicketManagement();{
					ticket.Ticket((String)showText.getText(), Integer.parseInt(rowText.getText()), Integer.parseInt(ticketText.getText()));
					ShowManagement sh = new ShowManagement();
					sh.UpdateShow((String)showText.getText());
				}
				
			}
			
		});
		
		
/////////////////////See Tickets Panel/////////////////////
		
viewTickets.setBounds(400,10,200,20);
mainPanel.add(viewTickets);


upShows.setBounds(800,10,150,40);
mainPanel.add(upShows);
upShows.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
		viewTickets.removeAllItems();
		ShowManagement show = new ShowManagement();
		for(Show temp:show.getShowDao()){
			
			viewTickets.addItem(temp.getShowTitle());
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
		
		TicketManagement tic = new TicketManagement();
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