package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class IntermForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton Accounts=new JButton("Account Management");
	private JButton Shows=new JButton("Shows Management");
	private JPanel MainPanel = new JPanel();
	public IntermForm()
	{
		super("Choose an Option");
		setSize(400,200);
		Accounts.setBounds(80, 20, 250, 30);
		MainPanel.add(Accounts);
		Accounts.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFormAccounts I = new AdminFormAccounts();	
				I.setVisible(true);
				setVisible(false);
				
			}
			
		});
		Shows.setBounds(80, 80, 250, 30);
		MainPanel.add(Shows);
		Shows.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				AdminFormShows I = new AdminFormShows();
				I.setVisible(true);
				setVisible(false);
				
			}
			
		});
		
		MainPanel.setLayout(null);
		
		this.add(MainPanel);
		this.setResizable(false);	
		this.setLocation(400, 100);
					
	}
	
}
