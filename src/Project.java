import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Project {
    private String valueScholarship;
    private String periodScholarship;
    private ProjectsParameters projectsParameters;

    private List<User> projectParticipants = new ArrayList<User>();
    private HashMap<String, Activity> activities = new HashMap<String, Activity>();

    public Project() {
    }

    public Project(ProjectsParameters nProjectsParameters) { 
        this.projectsParameters = nProjectsParameters;
        this.valueScholarship = "0,00";
        this.periodScholarship = "0";
    }

    

    public String getProjectName() {
        return projectsParameters.getProjectName();
    }
    public void setProjectName(String identification) {
        this.projectsParameters.setProjectName(identification);
    }
    public String getDescription() {
        return projectsParameters.getDescription();
    }
    public void setDescription(String description) {
        this.projectsParameters.setDescription(description);
    }
    public String getStartDate() {
        return projectsParameters.getStartDate();
    }
    public void setStartDate(String startDate) {
        this.projectsParameters.setStartDate(startDate);
    }
    public String getEndDate() {
        return projectsParameters.getEndDate();
    }
    public void setEndDate(String endDate) {
        this.projectsParameters.setEndDate(endDate);
    }
    public String getProjectCoordenador() {
        return projectsParameters.getProjectCoordenador();
    }
    public void setProjectCoordenador(String projectCoordenador) {
        this.projectsParameters.setProjectCoordenador(projectCoordenador);
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
        return projectsParameters.getStartHour();
    }
    public String getEndHour() {
        return projectsParameters.getEndHour();
    }
    public void setStartHour(String startHour) {
        this.projectsParameters.setStartHour(startHour);
    }
    public void setEndHour(String endHour) {
        this.projectsParameters.setEndHour(endHour);
    }

    public String getStatus() {
        return projectsParameters.getStatus();
    }

    public void setStatus(String status) {
        this.projectsParameters.setStatus(status);
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
