package pass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	private Connection conn;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	// Register for new User
	
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
	
	
	// View All users
	
    public List<Users> getAllUsers(){
		
		List<Users> users = new ArrayList<>();
		String sql = "SELECT * FROM USERS";
		
		try(Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				
				// Creates objects to Store row data
				Users user = new Users();
				
				// Copies the data from the Database columns
				user.setName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				user.setPhone(rs.getString("Phone"));
				user.setPassword(rs.getString("Password"));
				// Adds the one by one Objects into the users list
				users.add(user);
			}		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		// users List returned
		return users;
	}
}
