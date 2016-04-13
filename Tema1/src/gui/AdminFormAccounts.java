package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import business.AccountManager;



public class AdminFormAccounts extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton createAccount=new JButton("Create Account");
	
	private JComboBox<String> userType=new JComboBox<String> (); 
	
	private JLabel name = new JLabel("name");
	private JLabel userName= new JLabel("UserName");
	private JLabel password = new JLabel("Password");
	private JLabel typeLabel = new JLabel("Type of User");
	
	private JPasswordField passText = new JPasswordField();
	
	private JTextField nameText = new JTextField();
	private JTextField userText = new JTextField();

	private JPanel panel = new JPanel();
	public AdminFormAccounts()
	{
		super("Account Manager");
		setSize(400,450);
		
		
		panel.add(userType);
		name.setBounds(80, 50, 70, 30);
		panel.add(name);
		nameText.setBounds(150, 55, 150, 20);
		panel.add(nameText);
		
		userName.setBounds(80, 100, 70, 30);
		panel.add(userName);
		userText.setBounds(150, 105, 150, 20);
		panel.add(userText);
		
		password.setBounds(80, 150, 70, 30);
		panel.add(password);
		passText.setBounds(150, 155, 150, 20);
		panel.add(passText);
		
		userType.addItem("admin");
		userType.addItem("employee");
		userType.setBounds(100, 200, 200, 20);
		
		typeLabel.setBounds(20, 200, 200, 20);
		panel.add(typeLabel);
		createAccount.setBounds(100, 250, 200, 30);
		panel.add(createAccount);
		
		createAccount.addActionListener(new ActionListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
				
					String name=nameText.getText();
					String username=userText.getText();
					String pass=passText.getText();
					String type = (String) userType.getSelectedItem();
					AccountManager acc = new AccountManager();
					System.out.println("inainte de adaugare" + pass);
					pass = acc.cryptWithMD5(pass);
					acc.addAccount(name, username, pass, type);
					System.out.println("dupa adaugare " +  pass);
					nameText.setText("");
					userText.setText("");
					passText.setText("");
				
				}catch(Exception ex){
					ex.printStackTrace();}
			}
			
		});
		
		panel.setLayout(null);
		this.setLocation(400, 100);
		this.add(panel);
		this.setResizable(false);	
		}
	
	}

