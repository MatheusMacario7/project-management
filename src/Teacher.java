public class Teacher extends User {
    
    private String institution;

    public Teacher(String name, String email, String password, String institution) {
        super(name, email, password);
        this.institution = institution;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public void viewUser() {
        System.out.println("User type -> Teacher");
        System.out.println("Work institution -> " + this.getInstitution());
        super.viewUser();
    }

    
}