import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Project {
    private String projectName;
    private String description;
    private String startDate;
    private String startHour;
    private String endDate;
    private String endHour;
    private String projectCoordenador;
    private String valueScholarship;
    private String periodScholarship;
    private String status;

    private List<User> projectParticipants = new ArrayList<User>();
    //private List<Activity> activities = new ArrayList<Activity>();
    private HashMap<String, Activity> activities = new HashMap<String, Activity>();

    

    public  Project() { 
    }

    public Project(String projecName, String description, String startDate, String startHour, String endDate, String endHour, String projectCoordenador, String status, String valueScholarship, String periodScholarship) {
        this.projectName = projecName;
        this.description = description;
        this.startDate = startDate;
        this.startHour = startHour;
        this.endDate = endDate;
        this.endHour = endHour;
        this.projectCoordenador = projectCoordenador;
        this.status = status;
        this.valueScholarship = valueScholarship;
        this.periodScholarship = periodScholarship;

    }

    

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String identification) {
        this.projectName = identification;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getProjectParticipants() {
        return projectParticipants;
    }

    public void setProjectParticipants(User participants) {
        this.projectParticipants.add(participants);
    }

    public void setActivities(String activityName, Activity activities) {
        this.activities.put(activityName, activities);
    }
    
    public HashMap<String, Activity> getActivities(){
        return activities;
    }


}
