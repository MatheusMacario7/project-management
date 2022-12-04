public class Student extends User{
    
    private String subtype;

    public Student(String name, String email, String password, int op) {
        super(name, email, password);
        this.subtype = choiceSubtype(op);
    }

    private String choiceSubtype(int op) {

        if (op == 1) {
            return "Graduate Student";
        }
        if (op == 2) {
            return "Mastering Student";
        }
        if (op == 3) {
            return "PhD Student";
        }
        return "";
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