package gui;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import business.AccountManager;






public class UserFormRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton register=new JButton("Register");
	
	private JLabel firstName = new JLabel("First Name");
	private JLabel lastName= new JLabel("Last name");
	private JLabel email = new JLabel("Email");
	private JLabel username = new JLabel("Username");
	private JLabel password = new JLabel("Password");

	
	private JTextField firstNameText = new JTextField();
	private JTextField lastNameText = new JTextField();
	private JTextField emailText = new JTextField();
	private JTextField usernameText = new JTextField();
	private JPasswordField passwordText =new JPasswordField();
	
	private JPanel panel = new JPanel();
	public UserFormRegister()
	{
		super("Account Manager");
		setSize(400,450);
		
		
		firstName.setBounds(80, 50, 70, 30);
		panel.add(firstName);
		firstNameText.setBounds(150, 55, 150, 20);
		panel.add(firstNameText);
		lastName.setBounds(80, 100, 70, 30);
		panel.add(lastName);
		lastNameText.setBounds(150, 105, 150, 20);
		panel.add(lastNameText);
		email.setBounds(80, 150, 70, 30);
		panel.add(email);
		emailText.setBounds(150, 155, 150, 20);
		panel.add(emailText);
		username.setBounds(80, 200, 200, 20);
		panel.add(username);
		usernameText.setBounds(150, 205, 150, 20);
		panel.add(usernameText);
		password.setBounds(80,250,100,20);
		panel.add(password);
		passwordText.setBounds(150, 255, 150, 20);
		panel.add(passwordText);
		register.setBounds(80, 300, 200, 30);
		panel.add(register);
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					String firstName=firstNameText.getText();
					String lastName=lastNameText.getText();
					String email=emailText.getText();
					String username = usernameText.getText();
					
					@SuppressWarnings("deprecation")
					String password = passwordText.getText();
					
					AccountManager acc = new AccountManager();
					
					acc.addAccount(firstName, lastName, email, username, password, "client");
					System.out.println(email);
					firstNameText.setText("");
					lastNameText.setText("");
					emailText.setText("");
					usernameText.setText("");
					passwordText.setText("");
					LoginForm lf = new LoginForm();
					lf.setVisible(true);
					setVisible(false);
					}
				catch(Exception ex){
					ex.printStackTrace();
					}
				
			}
		});
		
		
		
		panel.setLayout(null);
		this.setLocation(400, 100);
		this.add(panel);
		this.setResizable(false);	
		}
	
	}

