package business.concrete;



import business.abstracts.UserService;
import core.GoogleAccountAdapter;
import dataAccess.concrete.DBUserDao;
import entities.concrete.User;

public class UserManager implements UserService{

	private DBUserDao userdao;
	private SignInCheckManager checkManager;
	private GoogleAccountAdapter accountService;
	
	public UserManager(DBUserDao userdao, SignInCheckManager checkManager, GoogleAccountAdapter accountService) {
		super();
		this.userdao = userdao;
		this.checkManager = checkManager;
		this.accountService = accountService;
	}


	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		if(this.checkManager.isValidMail(user) && this.checkManager.isValidPassword(user) && this.checkManager.checkFirstName(user)) {
			this.checkManager.clickToConfirm(user);
			
			
			System.out.println("Email doğrulama kodu gönderildi "+ user.getName()+" "+user.getLastName());
			this.userdao.add(user);
			//this.accountService.signUpToSystem(user.getEmail());
		}else {
			System.out.println("Kayıt başarısız! Lütfen bilgileri doğru ve eksiksiz giriniz.");
		}
		
	}

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		if(this.checkManager.isValidMail(user) && this.checkManager.isEmailPasswordValid(user)) {
			this.userdao.add(user);
			
		
			//this.checkManager.loginToSystem(user.getEmail());
		}else {
			System.out.println("Giriş başarısız.Email yada parolanızı adresinizi kontrol ediniz.");
		}
		
	}

	@Override
	public boolean loginWithGoogleService(String message) {
		
		this.accountService.logInWithExtenalAccount(message);
		return true;
		
	}
	
	
}
