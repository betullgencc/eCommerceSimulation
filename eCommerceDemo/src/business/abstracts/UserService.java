package business.abstracts;

import java.util.List;

import entities.concrete.User;

public interface UserService  {
	
	
	 void register (User user);
	 void login (User user);
	 boolean loginWithGoogleService(String message);

}
