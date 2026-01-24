package model;

// User Module
public class Users {
     private String Name;
     private String Email;
     private String Phone;
     private String Password;
     
     //Empty Constructor
     public Users() {}
     
     // Constructor without ID (For Registration)
     public Users(String Name, String Email, String Phone, String Password) {
    	 this.Name = Name;
    	 this.Email = Email;
    	 this.Phone = Phone;
    	 this.Password = Password;
     }
     
     // Getter and Setters
     
     public void setName(String Name) {
    	 this.Name = Name;
     }
     
     public String getName() {
    	 return Name;
     }
     
     public void setEmail(String Email) {
    	 this.Email = Email;
     }
     
     public String getEmail() {
    	 return Email;
     }
     
     public void setPhone(String Phone) {
    	 this.Phone = Phone;
     }
     
     public String getPhone() {
    	 return Phone;
     }
     
     public void setPassword(String Password) {
    	 this.Password = Password;
     }
     
     public String getPassword() {
    	 return Password;
     }
     
     
     @Override
     public String toString() {
    	 return "Name : " + Name + ", Password : " + Password + ", Email : " + Email + ", Phone : " + Phone;
     }

}
