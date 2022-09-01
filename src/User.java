import java.util.Scanner;

public class User {

   private String userName;
   private String password;
   private String userType;
   private String name;


   
public User(String username, String password, String userType, String name) {
    this.userName = username;
    this.password = password;
    this.userType = userType;
    this.name = name;
}
public User() {
}

public String showUser() {
    return  "\n---------------------------------" + 
            "\n1 - Name: " + getName() +
            "\n2 - User name: " + getUserName() + 
            "\n3 - User type: " + getUserType(); 
}

public void editUser() throws InterruptedException{
    int key = 0;
    Scanner input = new Scanner(System.in);
    do {

        System.out.print("Edit user");
        System.out.println(showUser());
        System.out.println("0 - RETURN");
        System.out.println("---------------------------------");
        System.out.print("Choose an option: ");
        key = input.nextInt();
        input.nextLine();

        switch (key) {
            case 1:
                System.out.print("Name: ");
                this.setName(input.nextLine());
                break;
            case 2:
                System.out.print("User name: ");
                this.setUserName(input.nextLine());
                break;    
            case 3:
                System.out.print("user type: ");
                this.setUserType(input.nextLine());                   
                break;

            case 0:
                App.homeMenu();
                return;
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                editUser();
                break;
        }
        
        input.nextLine();

    } while (key != 0);
 
}


public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getUserType() {
    return userType;
}
public void setUserType(String userType) {
    this.userType = userType;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

   
}
