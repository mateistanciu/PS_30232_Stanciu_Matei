package business;

import java.util.List;

import Models.Account;
import data.AccountDAO;

public class AccountManagement {

	public List<Account> getAccountDao() {
		AccountDAO acc = new AccountDAO();
		return acc.getAccount();

	}
	public void addAccount(String name, String userName, String password, String userType){
		
		Account acc = new Account(name,userName,password,userType);
		AccountDAO account=new AccountDAO();
		account.AddAccount(acc);
		
	}
}
