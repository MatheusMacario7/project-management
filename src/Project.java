import java.util.Scanner;

public class Project {
    private String identification;
    private String description;
    private String startDate;
    private String startHour;
    private String endDate;
    private String endHour;
    private String projectCoordenador;
    private String projectProfessionals;
    private String activities;
    private String valueScholarship;
    private String periodScholarship;

    



    public Project() {
    }

    public String showProject() {
        return  "\n---------------------------------" + 
                "\n1 - Identification: " + getIdentification() +
                "\n2 - Description: " + getDescription() + 
                "\n3 - Start date: " + getStartDate() + 
                "\n4 - Start hour: " + getStartHour() +
                "\n5 - End date: " + getEndDate() +
                "\n6 - End hour: " + getEndHour() +
                "\n7 - Project`s coordenador: " + getProjectCoordenador() +
                "\n8 - Activities: " + getActivities() +
                "\n9 - Scholarship value: " + getValueScholarship() +
                "\n10 - Period of validity of the scholarship: " + getPeriodScholarship();
                
    }


    public void editProject() throws InterruptedException{
        int key = 0;
        Scanner input = new Scanner(System.in);
        do {
    
            System.out.print("Edit project");
            System.out.println(showProject());
            System.out.println("0 - RETURN");
            System.out.println("---------------------------------");
            System.out.print("Choose an option: ");
            key = input.nextInt();
            input.nextLine();
    
            switch (key) {
                case 1:
                    System.out.print("Identification: ");
                    this.setIdentification(input.nextLine());
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
                    System.out.print("Project`s coordenador: ");
                    this.setProjectCoordenador(input.nextLine());                   
                    break;
                case 8:
                    System.out.print("Activities: ");
                    this.setActivities(input.nextLine());                   
                    break;
                case 9:
                    System.out.print("Scholarship value: ");
                    this.setValueScholarship(input.nextLine());                   
                    break;
                case 10:
                    System.out.print("Period of validity of the scholarship: ");
                    this.setPeriodScholarship(input.nextLine());                   
                    break;
                case 0:
                    App.homeMenu();
                    return;
                default:
                    System.out.println("Wrong choice! please enter a correct option.");
                    editProject();
                    break;
            }
            
            input.nextLine();
    
        } while (key != 0);
     
    }

    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
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
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getProjectCoordenador() {
        return projectCoordenador;
    }
    public void setProjectCoordenador(String projectCoordenador) {
        this.projectCoordenador = projectCoordenador;
    }
    public String getProjectProfessionals() {
        return projectProfessionals;
    }
    public void setProjectProfessionals(String projectProfessionals) {
        this.projectProfessionals = projectProfessionals;
    }
    public String getActivities() {
        return activities;
    }
    public void setActivities(String activities) {
        this.activities = activities;
    }
    public String getValueScholarship() {
        return valueScholarship;
    }
    public void setValueScholarship(String valueScholarship) {
        this.valueScholarship = valueScholarship;
    }
    public String getPeriodScholarship() {
        return periodScholarship;
    }
    public void setPeriodScholarship(String periodScholarship) {
        this.periodScholarship = periodScholarship;
    }
    public String getStartHour() {
        return startHour;
    }
    public String getEndHour() {
        return endHour;
    }
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }
    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }


    
}
