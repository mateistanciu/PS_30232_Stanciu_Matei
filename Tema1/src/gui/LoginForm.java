package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import business.AccountManager;




public class LoginForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton login=new JButton("Login");
	private JButton forgotPassword=new JButton("Forgot Password");
	private JLabel userName= new JLabel("UserName");
	private JLabel password = new JLabel("Password");
	private JTextField userText = new JTextField();
	private JPasswordField passText = new JPasswordField();
	private JPanel panel = new JPanel();
	public LoginForm()
	{
		super("Login Window");
		setSize(400,350);
		
		
		
		userName.setBounds(80, 100, 70, 30);
		panel.add(userName);
		userText.setBounds(150, 105, 150, 20);
		panel.add(userText);
		
		password.setBounds(80, 150, 70, 30);
		panel.add(password);
		passText.setBounds(150, 155, 150, 20);
		panel.add(passText);
		
		login.setBounds(130, 200,150, 30);
		panel.add(login);
		
		forgotPassword.setBounds(130, 250,150, 30);
		panel.add(forgotPassword);
		
		panel.setLayout(null);
		
		
		
			login.addActionListener(new ActionListener(){
			
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					
						String user = userText.getText();
						String pass = passText.getText();
						
						AccountManager account = new AccountManager();
						pass = account.cryptWithMD5(pass);
						try{
							if (account.checkAccounts(user, pass).equals("admin")){
								IntermForm I = new IntermForm();
								account.cryptWithMD5(pass);
								I.setVisible(true);
								setVisible(false);
							}
							else if(account.checkAccounts(user, pass).equals("employee")){
								EmployeeForm I = new EmployeeForm();
								I.setVisible(true);
								setVisible(false);
							}
							
						}catch(Exception e1){
							JOptionPane
							.showMessageDialog(
									null,
									"Invalid Username or Password",
									"Login Error", JOptionPane.ERROR_MESSAGE);
						}
						
							}
					
	});
			
			       
			    
			forgotPassword.addActionListener(new ActionListener(){
				
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String user = userText.getText();
					String pass = passText.getText();
					AccountManager account = new AccountManager();
					try{           
					      if(user.isEmpty()) 
					      {
					    	  JOptionPane
								.showMessageDialog(
										null,
										"You must insert a valid username first",
										"Update Error", JOptionPane.ERROR_MESSAGE);
					      }
			
					    
					      else {
					pass=account.nextSessionId();
					JOptionPane
					.showMessageDialog(
							null,
							"Your password is "+pass,
							"Password Update", JOptionPane.INFORMATION_MESSAGE);
					pass = account.cryptWithMD5(pass);
					account.updateAccounts(user, pass);
					      } 
					} catch(IllegalArgumentException e) {
						e.printStackTrace();	
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

