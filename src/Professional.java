public class Professional extends User{
    
    private String subtype;

    public Professional(String name, String email, String password, String subtype) {
        super(name, email, password);
        this.subtype = subtype;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @Override
    public void viewUser() {
        System.out.println("User type -> " + this.subtype);
        super.viewUser();
    }
}