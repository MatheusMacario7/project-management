import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Activity {
    private String activityName;
    private String description;
    private String startDate;
    private String startHour;
    private String endDate;
    private String endHour;
    private String responsibleActivity;

    private List<User> activityParticipants = new ArrayList<User>();
    private List<String> tasks = new ArrayList<String>();


    public Activity() {
    }

    public void showActivity() {
        System.out.println("---------------------------------------------"); 
                System.out.println("1 - Identification: " + getActivityName()); 
                System.out.println("2 - Description: " + getDescription()); 
                System.out.println("3 - Start date: " + getStartDate()); 
                System.out.println("4 - Start hour: " + getStartHour()); 
                System.out.println("5 - End date: " + getEndDate()); 
                System.out.println("6 - End hour: " + getEndHour());
                System.out.println("7 - Responsible for the activity: " + getResponsibleActivity()); 
                System.out.println("8 - Professionals involved: " + getActivityParticipants()); 
                System.out.println("9 - Tasks: ");
                
    }

    public void editActivity(User uConnected){
        int key = 0;
        Scanner input = new Scanner(System.in);
        do {
    
            System.out.print("Edit project");
            showActivity();
            System.out.println("0 - RETURN");
            System.out.println("---------------------------------");
            System.out.print("Choose an option: ");
            key = input.nextInt();
            input.nextLine();
    
            switch (key) {
                case 1:
                    System.out.print("Identification: ");
                    this.setActivityName(input.nextLine());
                    break;
                case 2:
                    System.out.print("Description: ");
                    this.setDescription(input.nextLine());;
                    break;    
                case 3:
                    System.out.print("Start date: ");
                    this.setStartDate(input.nextLine());                   
                    break;
                case 4:
                    System.out.print("Start hour: ");
                    this.setStartHour(input.nextLine());                  
                    break;
                case 5:
                    System.out.print("End date: ");
                    this.setEndDate(input.nextLine());                   
                    break;
                case 6:
                    System.out.print("End hour: ");
                    this.setEndHour(input.nextLine());                   
                    break;
                case 7:
                    System.out.print("Responsible for the activity: ");
                    this.setResponsibleActivity(input.nextLine());                   
                    break;
                case 8:
                    System.out.print("Professionals involved: ");
                    //this.setActivityParticipants(input.nextLine());                   
                    break;
                case 9:
                    System.out.print("Tasks: ");
                    //this.setTasks(input.nextLine());                   
                    break;
                case 0:
                    App.homePageMenu(uConnected);
                    return;
                default:
                    System.out.println("Wrong choice! please enter a correct option.");
                    editActivity(uConnected);
                    break;
            }
            
            input.nextLine();
    
        } while (key != 0);
     
    }


    
    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getStartHour() {
        return startHour;
    }
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getEndHour() {
        return endHour;
    }
    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
    public String getResponsibleActivity() {
        return responsibleActivity;
    }
    public void setResponsibleActivity(String responsibleActivity) {
        this.responsibleActivity = responsibleActivity;
    }

    public List<User> getActivityParticipants() {
        return activityParticipants;
    }

    public void setActivityParticipants(User activityParticipants) {
        this.activityParticipants.add(activityParticipants);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks.add(tasks);
    }

   

}
