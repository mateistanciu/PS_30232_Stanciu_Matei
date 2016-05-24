package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import business.AccountManager;



public class AdminFormAccounts extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton createAccount=new JButton("Create Account");
	private JButton back=new JButton("Back");
	private JComboBox<String> role=new JComboBox<String> (); 
	
	private JLabel firstName = new JLabel("First Name");
	private JLabel lastName= new JLabel("Last Name");
	private JLabel email = new JLabel("Email");
	private JLabel username = new JLabel("Username");
	private JLabel password = new JLabel("Password");	
	private JLabel roleLabel = new JLabel("Role");
	private JPasswordField passText = new JPasswordField();
	
	private JTextField firstNameText = new JTextField();
	private JTextField lastNameText = new JTextField();
	private JTextField emailText = new JTextField();
	private JTextField usernameText = new JTextField();
	private JPanel panel = new JPanel();
	public AdminFormAccounts()
	{
		super("Account Manager");
		setSize(400,550);
		
		
		panel.add(role);
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
		username.setBounds(80, 200, 100, 30);
		panel.add(username);
		usernameText.setBounds(150, 205, 150, 20);
		panel.add(usernameText);
		password.setBounds(80, 250, 70, 30);
		panel.add(password);
		passText.setBounds(150, 255, 150, 20);
		panel.add(passText);
		
		role.addItem("admin");
		role.addItem("employee");
		role.setBounds(150, 305, 150, 20);
		
		
		roleLabel.setBounds(80, 300, 150, 20);
		panel.add(roleLabel);
		
		
		
		createAccount.setBounds(100, 350, 200, 30);
		panel.add(createAccount);
		
		createAccount.addActionListener(new ActionListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
				
					String firstName=firstNameText.getText();
					String lastName=lastNameText.getText();
					String email= emailText.getText();
					String username = usernameText.getText();
					String password = passText.getText();
					String type = (String) role.getSelectedItem();
					
					AccountManager acc = new AccountManager();
						if(acc.checkUser(username)){
						JOptionPane
						.showMessageDialog(
								null,
								"Username Already Exists",
								"Account Error", JOptionPane.ERROR_MESSAGE);	
					}
					else{
					acc.addAccount(firstName, lastName, email, username, password, type);
					firstNameText.setText("");
					lastNameText.setText("");
					passText.setText("");
					emailText.setText("");
					usernameText.setText("");
					}
				}catch(Exception ex){
					ex.printStackTrace();}
			}
			
		});
		back.setBounds(100, 400 , 200, 30);
		panel.add(back);
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				IntermForm form = new IntermForm();
				form.setVisible(true);
				setVisible(false);
			}
			
		});
		
		panel.setLayout(null);
		this.setLocation(400, 100);
		this.add(panel);
		this.setResizable(false);	
		}
	
	
	}

