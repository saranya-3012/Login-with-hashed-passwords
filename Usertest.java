package pass;

import java.util.Scanner;

public class Usertest {
    public static void main(String[] args) {
    	try {
    	
        UserDAO userDAO = new UserDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== User Menu ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. View All Users");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                System.out.print("Enter phone: ");
                String phone = sc.nextLine();

                String HashedPassword = Passwordvalid.hashPassword(password);
                Users newUser = new Users(name, email, phone, HashedPassword);

                boolean registered = userDAO.registeruser(newUser);
                System.out.println(registered ? "Registered successfully!" : "Registration failed!");
                break;

            case 2:
                System.out.print("Enter email: ");
                String e = sc.nextLine();
                System.out.print("Enter password: ");
                String p = sc.nextLine();                
                
                String HashedPass = Passwordvalid.hashPassword(p);
                Users user = userDAO.loginUser(e, HashedPass);
                if (user != null)
                    System.out.println("✅ Login success! Welcome " + user.getName());
                else
                    System.out.println("Invalid email or password!");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    	}
    	catch (Exception e) {
    		e.getMessage();
    	}       
    }
}