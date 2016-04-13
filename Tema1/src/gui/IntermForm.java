package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class IntermForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton accounts=new JButton("Account Manager");
	private JButton shows=new JButton("Shows Manager");
	private JPanel mainPanel = new JPanel();
	public IntermForm()
	{
		super("Choose an Option");
		setSize(400,200);
		accounts.setBounds(80, 20, 250, 30);
		mainPanel.add(accounts);
		accounts.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFormAccounts I = new AdminFormAccounts();	
				I.setVisible(true);
				setVisible(false);
				
			}
			
		});
		shows.setBounds(80, 80, 250, 30);
		mainPanel.add(shows);
		shows.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFormShows I = new AdminFormShows();
				I.setVisible(true);
				setVisible(false);
				
			}
			
		});
		
		mainPanel.setLayout(null);
		this.add(mainPanel);
		this.setResizable(false);	
		this.setLocation(400, 100);
					
	}
	
}
