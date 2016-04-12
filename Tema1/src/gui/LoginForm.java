package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Models.Account;
import business.AccountManagement;




public class LoginForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton login=new JButton("Login");
	private JLabel userName= new JLabel("UserName");
	private JLabel password = new JLabel("Password");
	private JTextField userText = new JTextField();
	private JPasswordField passText = new JPasswordField();
	private JPanel panel = new JPanel();
	public LoginForm()
	{
		super("Log in Window");
		setSize(400,300);
		
		
		
		userName.setBounds(80, 100, 70, 30);
		panel.add(userName);
		userText.setBounds(150, 105, 150, 20);
		panel.add(userText);
		
		password.setBounds(80, 150, 70, 30);
		panel.add(password);
		passText.setBounds(150, 155, 150, 20);
		panel.add(passText);
		
		login.setBounds(160, 200,100, 30);
		panel.add(login);
		
		panel.setLayout(null);
		
		
		
			login.addActionListener(new ActionListener(){
			
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					
						String user = userText.getText();
						String pass = passText.getText();
						
						AccountManagement account = new AccountManagement();
						
						for(Account temp:account.getAccountDao()){
							if (temp.getUserName().equals(user) && temp.getPasswprd().equals(pass)){
								if(temp.getUserType().equals("admin")){
									IntermForm I = new IntermForm();
									I.setVisible(true);
									setVisible(false);
								}
								else {
									EmployeeForm I = new EmployeeForm();
									I.setVisible(true);
									setVisible(false);
								}
							}
						}
					}
					
	});
					
				
		
		this.add(panel);
		this.setResizable(false);	
		this.setLocation(400, 100);			
	}
	public static void main(String[] args) {
		LoginForm f = new LoginForm();
		f.setVisible(true);
	}
	
}

