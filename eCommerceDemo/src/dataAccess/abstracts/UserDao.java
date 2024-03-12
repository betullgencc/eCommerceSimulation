package dataAccess.abstracts;

import java.util.List;

import entities.concrete.User;


public interface UserDao {
	
	User get(int id);
	List<User> getAll();
	
	void add(User user);
	void update(User user);
	void delete(User user);

}
