package core;

import LogInWithAnAccount.GmailAccountService;
import core.abstracts.ExternalAccountService;

public class GoogleAccountAdapter implements ExternalAccountService {

	
	private GmailAccountService gmailAccountService;
	public GoogleAccountAdapter(GmailAccountService gmailAccountService) {
			super();
			this.gmailAccountService = gmailAccountService;
		}

	@Override
	public void registerWithExtenalAccount(String message) {
		// TODO Auto-generated method stub
		GmailAccountService gmailAccountService=new GmailAccountService();
		gmailAccountService.register(message);
		
	}

	@Override
	public void logInWithExtenalAccount(String message) {
		// TODO Auto-generated method stub
		GmailAccountService gmailAccountService=new GmailAccountService();
		gmailAccountService.login(message);
		
	}

	

}
