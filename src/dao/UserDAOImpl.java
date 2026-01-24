package dao;

import database.*;
import model.Users;
import java.sql.*;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn;
	
	public UserDAOImpl() {
		conn = DBConnection.getConnection();
	}
	
	// Register for new User
	@Override
	public boolean registeruser(Users user) {				
		String sql = "INSERT INTO USERS (NAME, EMAIL, PHONE, PASSWORD) VALUES (?, ?, ?, ?)";        
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());
			
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
				
	// Login User
	@Override
	public Users loginUser(String Email, String Password) {
		String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, Email);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();			
			
			if(rs.next()){
				
				Users u = new Users();				
				u.setName(rs.getString("Name"));
				u.setEmail(rs.getString("Email"));
				u.setPhone(rs.getString("Phone"));
				return u;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
