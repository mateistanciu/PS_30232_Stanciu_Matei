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
	private JButton register = new JButton("Register");
	
	private JLabel userName= new JLabel("UserName");
	private JLabel password = new JLabel("Password");
	private JLabel dontHaveAccount=new JLabel("Don't have an account?");
	
	private JTextField userText = new JTextField();
	private JPasswordField passText = new JPasswordField();
	private JPanel panel = new JPanel();
	public LoginForm()
	{
		super("Login Window");
		setSize(500,350);
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
		
		dontHaveAccount.setBounds(350, 100, 200, 30);
		panel.add(dontHaveAccount);
		
		register.setBounds(350, 150, 100, 30);
		panel.add(register);
		panel.setLayout(null);
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				UserFormRegister ufr = new UserFormRegister();
				
				setVisible(false);
				ufr.setVisible(true);
			}
			
		});
		login.addActionListener(new ActionListener(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
					String user = userText.getText();
					String pass = passText.getText();
					
					AccountManager account = new AccountManager();
					pass = account.cryptWithMD5(pass);
					String check  = account.checkAccount(user, pass);
					try{
						if (check.equals("admin")){
							IntermForm I = new IntermForm();
							account.cryptWithMD5(pass);
							I.setVisible(true);
							setVisible(false);
						}
						else if(check.equals("employee")){
							BikesForm bf = new BikesForm();
							bf.setVisible(true);
							setVisible(false);
						}
						else if(check.equals("client")){
							ClientForm cf = new ClientForm();
							cf.setVisible(true);
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
			public void actionPerformed(ActionEvent a) {
				
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
				      if(account.checkUser(user)){
				    	 JOptionPane
							.showMessageDialog(
									null,
									"Wrong username",
									"Update Error", JOptionPane.ERROR_MESSAGE);
				      }
				      else {
				pass=account.forgotPassword(pass);
				JOptionPane
				.showMessageDialog(
						null,
						"Your password is "+pass,
						"Password Update", JOptionPane.INFORMATION_MESSAGE);
				account.updateAccount(user, pass);
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
		ClientForm cf = new ClientForm();
		cf.setVisible(true);
		
	}
	
}

