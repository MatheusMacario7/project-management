import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        homeMenu();
    }

    public static void homeMenu() throws InterruptedException {
        int key;
        Scanner input = new Scanner(System.in);
        System.out.println("============== Project Management =============");
        System.out.println("1 - Create new user");
        System.out.println("2 - Create new Project");
        System.out.println("3 - Perform Activity");
        System.out.println("0 - EXIT");
        System.out.println("-----------------------------------------------");
        System.out.print("Choose an option: ");
        key =  input.nextInt();

        switch (key) {
            case 1:
                menuUser();
                homeMenu();
                break;
            case 2:
                projectMenu();
                homeMenu();
                break;

            case 3: 
                activitytMenu();
                homeMenu();
                break;

            case 0:
                System.out.println("Going out");
                break;
            default:
                System.out.println("Wrong choice");

                break;
        }

    }

    public static void menuUser() {
        User nUser = new User();
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("User Name: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        System.out.println("User type GS - Graduate Student" ); 
        System.out.println("          MS - Mastering Student"); 
        System.out.println("          PS - PhD Student");     
        System.out.println("          T - Teacher"); 
        System.out.println("          R - Researcher");
        System.out.println("          D - Developer"); 
        System.out.println("          TR - Tester"); 
        System.out.println("          A - Anayst"); 
        System.out.println("          TC - Techniquet");
        System.out.print("Choose an option: ");  
        String usertype = input.nextLine();

        nUser = new User(username, password, usertype, name);

    }

    public static void projectMenu() {
        Scanner input = new Scanner(System.in);
        Project nProject = new Project();
        System.out.print("Identification: ");
        nProject.setIdentification(input.nextLine());

        System.out.print("Description: ");
        nProject.setDescription(input.nextLine());

        System.out.print("Star date: ");
        nProject.setStartDate(input.nextLine());

        System.out.print("Star hour: ");
        nProject.setStartHour(input.nextLine());

        System.out.print("End date: ");
        nProject.setEndDate(input.nextLine());

        System.out.print("End hour: ");
        nProject.setEndHour(input.nextLine());

        System.out.print("Project`s coordenador: ");
        nProject.setProjectCoordenador(input.nextLine());

        System.out.print("Professionals involved: ");
        nProject.setProjectProfessionals(input.nextLine());

        System.out.print("Activities: ");
        nProject.setActivities(input.nextLine());

        System.out.print("Scholarship value: ");
        nProject.setValueScholarship(input.nextLine());

        System.out.print("Period of validity of the scholarship: ");
        nProject.setPeriodScholarship(input.nextLine());
    }

    public static void activitytMenu() {
        Scanner input = new Scanner(System.in);
        Activity nActivity = new Activity();
        System.out.print("Identification: ");
        nActivity.setIdentification(input.nextLine());

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

        System.out.print("Responsible for the activity: ");
        nActivity.setResponsibleActivity(input.nextLine());

        System.out.print("Professionals involved: ");
        nActivity.setProjectProfessionals(input.nextLine());

        System.out.print("Task to be performed: ");
        nActivity.setTasks(input.nextLine());








    }
}
