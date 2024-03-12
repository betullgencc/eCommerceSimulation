package business.concrete;

import java.util.List;

import java.util.regex.Pattern;

import business.abstracts.SignInCheckService;
import entities.concrete.User;

public class SignInCheckManager implements SignInCheckService {

	
	List<User> users;
	@Override
	public boolean checkFirstName(User user) {
		if(user.getName().isEmpty()){
			
			System.out.println("İsim alanı zorunludur!");
			return false;
		}
		if(user.getName().length()<2)
		{
			System.out.println("İsim en az iki karakterden oluşmalıdır!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().length() <2)
		{
			System.out.println("Soyisim en az iki karakterden oluşmalıdır!");
			return false;
			
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isValidPassword(User user) {
		// TODO Auto-generated method stub
		
		if (user.getPassword().length() < 6) {
			System.out.println("Şifreniz en az 2 karakterden oluşmalıdır");
			return false;
		}
		return true;
	}

	@Override
	public boolean isValidMail(User user) {
		// TODO Auto-generated method stub
		
		String regex = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        if (user.getEmail().isEmpty()) {
            System.out.println("Email boş bırakılmaz geçerli bir e-mail adresi giriniz.");
            return false;

        } else {
            if (!pattern.matcher(user.getEmail()).find()) {
                System.out.println("Email adresiniz geçersizdir!");
                return false;
            }
        }
        return true;
    }
		
		 
	

	@Override
	public boolean isUniqueMail(User user) {
		// TODO Auto-generated method stub
		
		for(User i: users ) {
			if(i.getEmail()==user.getEmail()) {
				System.out.println("Bu mail adresi kayıtlıdır");
			}
		}
			
		return false;
	}

	@Override
	public boolean isEmailPasswordValid(User user) {
		
		
		//**//
		if(user.getEmail() == user.getEmail() && user.getPassword()==user.getPassword()) {
			return true;
		
	}else {
		return false;
	}
	}

	@Override
	public boolean clickToConfirm(User user) {
		
		System.out.println("Doğrulama linki mail adresinize gönderildi"
				+ "Email: "+user.getEmail());
		return false;
	}

	
	

	


}
