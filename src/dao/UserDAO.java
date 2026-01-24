package dao;

import model.Users;

public interface UserDAO {
	
	// Registration
	boolean registeruser(Users user);
	
	// Login
	Users loginUser(String Email, String Password);
}
