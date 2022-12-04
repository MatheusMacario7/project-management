import java.util.HashMap;
import java.util.Scanner;

public class App {
    static User nUser = new User();
    static Project nProject = new Project();
    static Activity nActivity = new Activity();

    public static int loadInput() throws InterruptedException {
        Scanner input =  new Scanner(System.in);
        boolean correctInput = false;
        int key = -1;
        while (!correctInput) {
            try {
                key = Integer.parseInt(input.next());
                
                correctInput = true;
                
            } catch (Exception e) {
                System.out.println("Invalid Input. Enter available values!");
                return key;
            }  
        }
        return key;
    }
    public static void main(String[] args) throws Exception {
        startMenu();
    }

    static HashMap<String, User> users = new HashMap<String, User>();
    static HashMap<String, Project> projects = new HashMap<String, Project>();
    static HashMap<String, Activity> activities = new HashMap<String, Activity>();

    public static void startMenu() throws InterruptedException {
        int key;
        Scanner input = new Scanner(System.in);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("============== Project Management System =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("1 -> Create new user");
        System.out.println("2 -> Login");
        System.out.println("0 -> Close app");
        System.out.println("------------------------------------------------------");
        System.out.print("Choose an option -> ");
        key = loadInput();

        if (key == -1) {
            startMenu();
        }

        switch (key) {
            case 1:
                menuUser();
                startMenu();
                break;
            case 2:
                loginMenu();
                break;
    
            case 0:
                System.out.println("Logging out...");
                System.exit(0);
                break;
        
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                startMenu();
                break;
        }

    }

    public static void loginMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("============== Login =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("Email -> ");
        String email_in = input.nextLine();
        System.out.print("Password -> ");
        String password_in = input.nextLine();

        if (!users.containsKey(email_in)) {
            System.out.println("Email not found!");
            startMenu();
        }
        else if (users.get(email_in).getPassword().equals(password_in)) {
            System.out.println("Login successfully");
            homePageMenu(users.get(email_in));
        }else{
            System.out.println("Wrong password");
            loginMenu();
        }
    }

    public static void homePageMenu(User uConnected) throws InterruptedException{

        int key;
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("============== Home page =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("1 -> Create project");
        System.out.println("2 -> My projects");
        System.out.println("3 -> Edit user");
        System.out.println("4 -> Search");
        System.out.println("5 -> Remove account");
        System.out.println("0 -> EXIT");
        System.out.println("--------------------------------------");
        System.out.print("Choose an option -> ");
        key = loadInput();

        if (key == -1) {
            homePageMenu(uConnected);
        }

        switch (key) {
            case 1:
                newProject(uConnected);
                homePageMenu(uConnected);
                break;
            case 2:
                myProjects(uConnected);
                homePageMenu(uConnected);
                break;

            case 3: 
                nUser.editUser(uConnected);
                homePageMenu(uConnected);
                break;

            case 4:
                searchMenu(uConnected);
                homePageMenu(uConnected);
                break;

            case 5:
                users.remove(uConnected.getEmail(), uConnected);
                System.out.println("Account removed");
                startMenu(); 
                break;

            case 0:
                startMenu();
                break;
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                break;
        }

    }

    public static void showUserType() {
        System.out.println("----------------------------");
        System.out.println("User type:" );
        System.out.println("Student---------------------");
        System.out.println("1 -> Graduate Student"); 
        System.out.println("2 -> Mastering Student"); 
        System.out.println("3 -> PhD Student");
        System.out.println("----------------------------");     
        System.out.println("4 -> Teacher"); 
        System.out.println("5 -> Researcher");
        System.out.println("Professional--------------- ");
        System.out.println("6 -> Developer"); 
        System.out.println("7 -> Tester"); 
        System.out.println("8 -> Analyst"); 
        System.out.println("9 -> Technician");
        System.out.println("----------------------------");
        System.out.print("Choose an option -> ");
    }

    public static void menuUser() throws InterruptedException {
       
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        showUserType(); 
        int op = loadInput();

        if (op == -1) {
            menuUser();
        }

        if (op >= 1 && op <= 3 ) {
            nUser = new Student( name, email, password, op);
        }
        if (op >= 6 && op <= 9 ) {
            nUser = new Professional( name, email, password, op);
        }
        else {
            System.out.print("Name of the institution where you work -> ");
            String institution = input.nextLine();
            if (op == 4) {
                nUser = new Teacher( name, email, password, institution);
            }
            else
                nUser = new Researcher( name, email, password, institution);   
        }
        users.put(email, nUser);
    }

    public static void newProject(User uConnected) throws InterruptedException {
        if (!(uConnected.getClass().getName().equals("Teacher") || uConnected.getClass().getName().equals("Researcher"))) {
            System.out.println("Only teachers and researchers can create a project");
            homePageMenu(uConnected);
        }else{
            ProjectsParameters nProjectsParameters =  new ProjectsParameters();
            Scanner input = new Scanner(System.in);
           
            String projectCoordenador = uConnected.getName();
            nProjectsParameters.setProjectCoordenador(projectCoordenador);
            
            System.out.print("Project Name : ");
            String projectName = input.nextLine();
            nProjectsParameters.setProjectName(projectName);

            System.out.print("Description: ");
            String description = input.nextLine();
            nProjectsParameters.setDescription(description);

            System.out.print("Start date: ");
            String startDate = input.nextLine();
            nProjectsParameters.setStartDate(startDate);

            System.out.print("Start hour: ");
            String startHour = input.nextLine();
            nProjectsParameters.setStartHour(startHour);

            System.out.print("End date: ");
            String endDate = input.nextLine();
            nProjectsParameters.setEndDate(endDate);

            System.out.print("End hour: ");
            String endHour = input.nextLine();
            nProjectsParameters.setEndHour(endHour);

            String status = "In process of creation";
            nProjectsParameters.setStatus(status);

            Project nProject = new Project(nProjectsParameters);
            projects.put(projectName, nProject);
            uConnected.setMyProjects(nProject);
        }
    }

    public static void myProjects(User uConnected) throws InterruptedException {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("============== My Projects =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        if(!uConnected.getMyProjects().isEmpty()) {
            int i = 1;    
            for (Project p : uConnected.getMyProjects())
                System.out.println((i++)+" -> "+p.getProjectName());
        }else{
            System.out.println("You are not part of any project!");
        }
        System.out.println("0 -> RETURN");
        System.out.print("Choose an option -> ");
        int op = loadInput();
        if (op == -1) {
            myProjects(uConnected);
        }  
        if (op != 0) {
            --op;
            showProject(uConnected.getMyProjects().get(op), uConnected, op);
        }else homePageMenu(uConnected);
        
    }

    public static void showProject(Project pConnected, User uConnected, int index) throws InterruptedException {
            Scanner input = new Scanner(System.in);
            System.out.println("---------------------------------------------" );
            System.out.println("1 -> Project name: " + pConnected.getProjectName()); 
            System.out.println("2 -> Description: " + pConnected.getDescription());    
            System.out.println("3 -> Start date: " + pConnected.getStartDate());    
            System.out.println("4 -> Start hour: " + pConnected.getStartHour());    
            System.out.println("5 -> End date: " + pConnected.getEndDate());    
            System.out.println("6 -> End hour: " + pConnected.getEndHour());    
            System.out.println("7 -> Project`s coordenador: " + pConnected.getProjectCoordenador());    
            System.out.println("8 -> Activities: " + pConnected.getActivities().size());    
            System.out.println("9 -> Scholarship value: R$" + pConnected.getValueScholarship());    
            System.out.println("10 -> Period of validity of the scholarship: " + pConnected.getPeriodScholarship());
            System.out.println("11 -> Project participants: "+ pConnected.getProjectParticipants().size());
            System.out.println("12 -> Status : " + pConnected.getStatus());
            System.out.println("---------------------------------------------" );
            System.out.println("0 -> RETURN");

            if (uConnected.getMyProjects().get(index).getProjectCoordenador().equals(uConnected.getName())) {
                System.out.print("Select an option to edit -> ");
                int op = loadInput();

                if (op == -1) {
                    showProject(pConnected, uConnected, index);
                }
                editProject(pConnected, uConnected, op, index);
            }else{
                System.out.print("Press any key to go back -> ");  
                String op = input.next();
            }  
    }

    public static void editProject(Project pConnected, User uConnected, int op, int index) throws InterruptedException{
        Scanner input = new Scanner(System.in);
        if (op != 0) {
            switch (op) {
                case 1:
                    System.out.print("Project Name: ");
                    pConnected.setProjectName(input.nextLine());
                    showProject(pConnected, uConnected, index);
                    break;
                case 2:
                    System.out.print("Description: ");
                    pConnected.setDescription(input.nextLine());
                    showProject(pConnected, uConnected, index);
                    break;    
                case 3:
                    System.out.print("Start date: ");
                    pConnected.setStartDate(input.nextLine());
                    showProject(pConnected, uConnected, index);                   
                    break;
                case 4:
                    System.out.print("Start hour: ");
                    pConnected.setStartHour(input.nextLine());
                    showProject(pConnected, uConnected, index);                  
                    break;
                case 5:
                    System.out.print("End date: ");
                    pConnected.setEndDate(input.nextLine());
                    showProject(pConnected, uConnected, index);                   
                    break;
                case 6:
                    System.out.print("End hour: ");
                    pConnected.setEndHour(input.nextLine());
                    showProject(pConnected, uConnected, index);                   
                    break;
                case 7:
                    System.out.println("The project coordinator cannot be changed");
                    showProject(pConnected, uConnected, index);                  
                    break;
                case 8:
                    activitytMenu(uConnected, pConnected);
                    showProject(pConnected, uConnected, index);                    
                    break;
                case 9:
                    System.out.print("Scholarship value: ");
                    pConnected.setValueScholarship(input.nextLine()); 
                    showProject(pConnected, uConnected, index);                   
                    break;
                case 10:
                    System.out.print("Period of validity of the scholarship: ");
                    pConnected.setPeriodScholarship(input.nextLine()); 
                    showProject(pConnected, uConnected, index);                   
                    break;
                case 11:
                    projectParticipantsMenu(pConnected, uConnected);
                    showProject(pConnected, uConnected, index);
                case 12:
                    if(pConnected.getStatus().equals("In process of creation")) {
                        if(pConnected.getValueScholarship() == "0,00" || pConnected.getPeriodScholarship() == "0" || pConnected.getProjectParticipants().isEmpty()){
                            System.out.println("Incomplete information! Give more information about the project.");
                        }else{
                            pConnected.setStatus("Started");
                            System.out.println("Status changed to 'Started' ");
                        }
                    }
                    else if (pConnected.getStatus().equals("Started")) {
                        if(pConnected.getActivities().isEmpty()){
                            System.out.println("Incomplete information! First create an activity.");
                        }else{
                            pConnected.setStatus("In progress");
                            System.out.println("Status changed to 'In progress'");
                        }      
                    }
                    else if (pConnected.getStatus().equals("In progress")) {
                        pConnected.setStatus("completed");
                        System.out.println("Status changed to 'completed'");
                    }
                    showProject(pConnected, uConnected, index);
                    break;
                default:
                    System.out.println("Wrong choice! please enter a correct option.");
                    showProject(pConnected, uConnected, index); 
                    break;
            }
        }else myProjects(uConnected);
    }

    public static void projectParticipantsMenu(Project pConnected, User uConnected) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("============== Project participants =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("1 -> Add participant"); 
        System.out.println("2 -> See participants");
        System.out.println("0 -> RETURN");
        System.out.print("Choose an option -> "); 
        int op = loadInput();

        if (op == -1) {
            projectParticipantsMenu(pConnected, uConnected);
        } 

        switch (op) {
            case 1:
                System.out.print("Enter participant email: ");
                    String email_part = input.next();
                    if (!users.containsKey(email_part)) {
                        System.out.println("User not found!");
                    }else{
                        pConnected.setProjectParticipants(users.get(email_part));
                        users.get(email_part).setMyProjects(pConnected);
                        users.get(email_part).setScholarshipvalue(pConnected.getValueScholarship());
                        uConnected.setScholarshipvalue(pConnected.getValueScholarship());
                    }
                projectParticipantsMenu(pConnected, uConnected);
                break;
            case 2:
            System.out.println("Participants -> ");
                if (pConnected.getProjectParticipants().isEmpty()) {
                    System.out.println("No participants");
                }else{
                    for(User u : pConnected.getProjectParticipants()) {
                        if(!u.equals(pConnected.getProjectParticipants().get(0))) System.out.print(", ");
                        System.out.print(u.getName());
                    }
                }
                    
                System.out.println();
                projectParticipantsMenu(pConnected, uConnected);
                break;
            case 0:
                return;
        
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                projectParticipantsMenu(pConnected, uConnected);
                break;
        }


    }

    public static void activitytMenu(User uConnected, Project pConnected) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("============== Activities =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("1 -> Create activity"); 
        System.out.println("2 -> See activities");
        System.out.println("0 -> RETURN");
        System.out.print("Choose an option -> "); 
        int op = loadInput();

        if (op == -1) {
            activitytMenu(uConnected, pConnected);
        }
        
        switch (op) {
            case 1:
                newActivity(uConnected, pConnected);
                activitytMenu(uConnected, pConnected);
                break;
            case 2:
                System.out.println("Activities -> ");
                if (pConnected.getActivities().isEmpty()) {
                    System.out.println("No activities");
                }else{
                    showActivity(pConnected);
                    System.out.print("Press any key to go back -> "); 
                    String key = input.next();

                }
                activitytMenu(uConnected, pConnected);
                break;
        
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                break;
        }

        

    }

    public static void newActivity(User uConnected, Project pConnected) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        Activity nActivity = new Activity();
        nActivity.setResponsibleActivity(uConnected.getName());
        System.out.print("Activity name: ");
        nActivity.setActivityName(input.nextLine());

        System.out.print("Description: ");
        nActivity.setDescription(input.nextLine());

        System.out.print("Star date: ");
        nActivity.setStartDate(input.nextLine());

        System.out.print("Star hour: ");
        nActivity.setStartHour(input.nextLine());

        System.out.print("End date: ");
        nActivity.setEndDate(input.nextLine());

        System.out.print("End hour: ");
        nActivity.setEndHour(input.nextLine());

        activityParticipantsMenu(pConnected, nActivity);

        activities.put(nActivity.getActivityName(), nActivity);
        pConnected.setActivities(nActivity.getActivityName(), nActivity);
        
    }

    public static void activityParticipantsMenu(Project pConnected, Activity nActivity) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("============== Activity participants =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("1 -> Add participant"); 
        System.out.println("2 -> See participants");
        System.out.println("0 -> RETURN");
        System.out.print("Choose an option -> "); 
        int op = loadInput();

        if (op == -1) {
            activityParticipantsMenu(pConnected, nActivity);
        } 

        switch (op) {
            case 1:
                System.out.print("Enter participant email: ");
                    String email_part = input.next();
                    input.nextLine();
                    if (!users.containsKey(email_part)) {
                        System.out.println("User not found!");
                    }else{
                        System.out.print("Task to do: ");
                        String task_part = input.nextLine();
                        nActivity.setActivityParticipants(users.get(email_part));
                        nActivity.setTasks(task_part);
                        users.get(email_part).setMyActivity(nActivity);
                    }
                activityParticipantsMenu(pConnected,nActivity);
                break;
            case 2:
                System.out.println("Participants -> ");
                int index = 0;
                for(User u : nActivity.getActivityParticipants()) {
                    System.out.println("> " + u.getName() + " <-> "+ nActivity.getTasks().get(index));
                    index++;
                }
                activityParticipantsMenu(pConnected, nActivity);
                break;
            case 0:
                return;
        
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                activityParticipantsMenu(pConnected, nActivity);
                break;
        }
    }

    public static void showActivity(Project pConnected) { 
        for(Activity a : pConnected.getActivities().values()) {
            System.out.println("---------------------------------------------"); 
            System.out.println("Activity name: " + a.getActivityName()); 
            System.out.println("Description: " + a.getDescription()); 
            System.out.println("Start date: " + a.getStartDate()); 
            System.out.println("Start hour: " + a.getStartHour()); 
            System.out.println("End date: " + a.getEndDate()); 
            System.out.println("End hour: " + a.getEndHour());
            System.out.println("Responsible for the activity: " + a.getResponsibleActivity()); 
            System.out.println("Activity participants: ");
            
                int index = 0;
                for(User u : a.getActivityParticipants()) {
                    System.out.println("> " + u.getName() + " <-> "+ a.getTasks().get(index));
                    index++;
                }
        }        
    }

    public static void searchMenu(User uConnected) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("============== Search =============");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("1 -> Search by user"); 
        System.out.println("2 -> Search by project");
        System.out.println("3 -> Search by activity");
        System.out.println("0 -> RETURN");
        System.out.print("Choose an option -> "); 
        int op = loadInput();

        if (op == -1) {
            searchMenu(uConnected);
        }

        switch (op) {
            case 1:
                System.out.print("User email -> ");
                String email_user = input.next();
                if (!users.containsKey(email_user)) {
                System.out.println("User not found!");
                }else{
                    System.out.println("-------------------------------------");
                    users.get(email_user).viewUser();
                }
                searchMenu(uConnected);
                break;
            case 2:
                System.out.print("Project name -> ");
                String project_search = input.nextLine();
                if (!projects.containsKey(project_search)) {
                    System.out.println("Project not found!");
                }else{
                viewProject(projects.get(project_search));
                }
                searchMenu(uConnected);
                break;
            case 3:
                System.out.print("Activity name -> ");
                String activity_search = input.nextLine();
                if (!activities.containsKey(activity_search)) {
                    System.out.println("Activity not found!");
                }else{
                viewActivity(activities.get(activity_search));
                }
                searchMenu(uConnected);
                break;

            case 0:
                homePageMenu(uConnected);
                break;
        
            default:
                System.out.println("Wrong choice! please enter a correct option.");
                break;
        }

    }

    public static void viewProject(Project p) {
            System.out.println("---------------------------------------------" );
            System.out.println("Project name: " + p.getProjectName()); 
            System.out.println("Description: " + p.getDescription());    
            System.out.println("Start date: " + p.getStartDate());    
            System.out.println("Start hour: " + p.getStartHour());    
            System.out.println("End date: " + p.getEndDate());    
            System.out.println("End hour: " + p.getEndHour());    
            System.out.println("Project`s coordenador: " + p.getProjectCoordenador());    
            System.out.println("Activities: " + p.getActivities().size());    
            System.out.println("Scholarship value: R$" + p.getValueScholarship());    
            System.out.println("Period of validity of the scholarship: " + p.getPeriodScholarship());
            System.out.println("Project participants: "+ p.getProjectParticipants().size());
            System.out.println("Status : " + p.getStatus());
            System.out.println("---------------------------------------------" );
    }

    public static void viewActivity(Activity a) {
            System.out.println("---------------------------------------------"); 
            System.out.println("Activity name: " + a.getActivityName()); 
            System.out.println("Description: " + a.getDescription()); 
            System.out.println("Start date: " + a.getStartDate()); 
            System.out.println("Start hour: " + a.getStartHour()); 
            System.out.println("End date: " + a.getEndDate()); 
            System.out.println("End hour: " + a.getEndHour());
            System.out.println("Responsible for the activity: " + a.getResponsibleActivity()); 
            System.out.println("Activity participants: ");
            
                int index = 0;
                for(User u : a.getActivityParticipants()) {
                    System.out.println("> " + u.getName() + " <-> "+ a.getTasks().get(index));
                    index++;
                }
        
    }


}
