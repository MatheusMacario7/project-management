import java.util.ArrayList;
import java.util.List;

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
