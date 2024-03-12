import business.abstracts.UserService;
import business.concrete.SignInCheckManager;
import business.concrete.UserManager;
import dataAccess.concrete.DBUserDao;
import entities.concrete.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
         User user1 = new User(1,"Amine","Hifa","hifa@gmail.com","20002000");
         ;
		
	UserService userService = new UserManager(new DBUserDao(),new SignInCheckManager());
	userService.register(user1);
	
      

	}

}
