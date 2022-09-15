import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private String name;
    private String email;
    private String password;
    private String userType;
    private String scholarshipValue;
   
    private List<Project> myProjects = new ArrayList<Project>();
    private List<Activity> myActivity = new ArrayList<Activity>();
    


public User(String name, String email, String password, String userType, String scholarshipValue ) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.userType = userType;
    this.scholarshipValue = scholarshipValue;
    
}
public User() {
}

public String showUser() {
    return  "\n---------------------------------" + 
            "\n1 - Name: " + getName() +
            "\n2 - User type: "  + getUserType() +
            "\n3 - Password: " + getPassword(); 
}

public void editUser(User uConnected){
        Scanner input = new Scanner(System.in);
        System.out.print("Edit user");
        System.out.println(showUser());
        System.out.println("0 - RETURN");
        System.out.println("---------------------------------");
        System.out.print("Choose an option: ");
        int op = Integer.parseInt(input.next());
        input.nextLine();

        switch (op) {
            case 1:
                System.out.print("Name: ");
                uConnected.setName(input.nextLine());
                editUser(uConnected);
                break;
            case 2:
                System.out.print("User type: ");
                uConnected.setUserType(input.nextLine());
                editUser(uConnected);
                break;    
            case 3:
                System.out.print("New password: ");
                uConnected.setPassword(input.nextLine()); 
                editUser(uConnected);                  
                break;

            case 0:
                App.homePageMenu(uConnected);
                return;
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                editUser(uConnected);
                break;
        }
 
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
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public List<Project> getMyProjects() {
    return myProjects;
}
public void setMyProjects(Project projects) {
    this.myProjects.add(projects);
}

public List<Activity> getMyActivity() {
    return myActivity;
}
public void setMyActivity(Activity myActivity) {
    this.myActivity.add(myActivity);
}

public String getScholarshipvalue() {
    return scholarshipValue;
}
public void setScholarshipvalue(String scholarshipvalue) {
    this.scholarshipValue = scholarshipvalue;
}

   
}
