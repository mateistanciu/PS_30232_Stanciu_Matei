package business;




import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import Models.Account;
import data.AccountDAO;

public class AccountManager {

	
	 private MessageDigest md;
	 private SecureRandom random = new SecureRandom();

	  public String nextSessionId(String password) {
		  password = new BigInteger(25, random).toString(32); 
	    return password;
	  }
	  
	   public String cryptWithMD5(String pass){
	    try {
	       
	    	md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	        return null;
	   }
	   
	public String checkAccounts(String user, String password) {
		
		AccountDAO acc = new AccountDAO();
		return acc.checkAccount(user, password);
	}
	
	public boolean checkUser(String user) {
		
		AccountDAO acc = new AccountDAO();
		if(acc.checkUsername(user))
			return true;
		else return false;
	}
	
	public void updateAccounts(String username, String password) {
		
		AccountDAO acc = new AccountDAO();
		AccountManager cryptPassword = new AccountManager();
	    password= cryptPassword.cryptWithMD5(password);
		acc.updateAccount(username, password);
	}
	public String forgotPassword(String password){
		AccountManager pass = new AccountManager();
		return pass.nextSessionId(password);
	}
	
	public void addAccount(String name, String userName, String password, String userType){
		
		AccountManager cryptPass = new AccountManager();
	    password= cryptPass.cryptWithMD5(password);
		Account acc = new Account(name,userName,password,userType);
		AccountDAO account=new AccountDAO();
		account.AddAccount(acc);
		
	}
}
