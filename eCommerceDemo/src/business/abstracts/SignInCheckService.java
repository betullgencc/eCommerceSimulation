package business.abstracts;

import entities.concrete.User;

public interface SignInCheckService {
	
	
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean isValidPassword(User user);
	boolean isValidMail(User user);
	boolean isUniqueMail(User user);
	boolean isEmailPasswordValid(User user);
	boolean clickToConfirm(User user);
	

}
