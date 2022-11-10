import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private String name;
    private String email;
    private String password;
    private String scholarshipValue;
   
    private List<Project> myProjects = new ArrayList<Project>();
    private List<Activity> myActivity = new ArrayList<Activity>();
    


public User(String name, String email, String password, String scholarshipValue) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.scholarshipValue = scholarshipValue;
    
}

public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.scholarshipValue = "R$0,00";
    
}
public User() {
}

public String showUser(User uConnected) {
    return  "\n---------------------------------" + 
            "\n1 -> Name: " + uConnected.getName() +
            "\n2 -> Email: "  + uConnected.getEmail() +
            "\n3 -> Password: " + uConnected.getPassword(); 
}

public void editUser(User uConnected) throws InterruptedException{
        Scanner input = new Scanner(System.in);
        System.out.print("Edit user");
        System.out.println(showUser(uConnected));
        System.out.println("0 - RETURN");
        System.out.println("---------------------------------");
        System.out.print("Choose an option: ");
        int op = App.loadInput();

        if (op == -1) {
            editUser(uConnected);
        }

        switch (op) {
            case 1:
                System.out.print("Name: ");
                uConnected.setName(input.nextLine());
                editUser(uConnected);
                break;
            case 2:
                System.out.print("Email: ");
                uConnected.setEmail(input.nextLine());
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


public void viewUser() {
    System.out.println("Name -> " + this.getName());
    System.out.println("Email -> " + this.getEmail());
    System.out.println("Projects -> ");
        if(!this.getMyProjects().isEmpty()) {
            int i = 1;    
            for (Project p : this.getMyProjects()){
                System.out.println((i++)+" -> "+p.getProjectName());
            }
            System.out.println("Scholarship value -> R$" + this.getScholarshipvalue());
        }else{
            System.out.println("No project!");
        }

    System.out.println("Activities -> ");
        if(!this.getMyActivity().isEmpty()) {
            int i = 1;    
            for ( Activity a : this.getMyActivity())
                System.out.println((i++)+" -> "+a.getActivityName());
        }else{
            System.out.println("No Activity!");
        }
}




public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
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
