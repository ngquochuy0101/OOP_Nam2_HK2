import java.io.File; 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class UserManagement {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    System.out.print("1. Login \n2. Signup\nEnter your choice: ");
    int choice = input.nextInt();
    
    if(choice == 1) {
      login();
    }
    else if(choice == 2) {
      signup(); 
    }
  }

  public static void login() {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter username: ");
    String username = input.nextLine();
    
    System.out.print("Enter password: ");
    String password = input.nextLine();
    
    try {
      Scanner fileReader = new Scanner(new File("users.txt"));
      while(fileReader.hasNextLine()) {
        String[] userData = fileReader.nextLine().split(",");
        if(userData[0].equals(username) && userData[1].equals(password)) {
          System.out.println("Login successful!");
          return;
        }
      }
      System.out.println("Invalid credentials!");
    } catch (Exception e) {
      System.out.println("Error accessing user file");
    }
  }
  
  public static void signup() {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter username: ");
    String username = input.nextLine();
    
    System.out.print("Enter password: ");
    String password = input.nextLine();
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
      writer.write(username + "," + password);
      writer.newLine();
      writer.close();
      
      System.out.println("User registered successfully!");
    } catch (Exception e) {
      System.out.println("Error registering user");
    }
  }
  
}