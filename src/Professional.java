public class Professional extends User{
    
    private String subtype;

    public Professional(String name, String email, String password, int op) {
        super(name, email, password);
        this.subtype = choiceSubtype(op);
    }

    private String choiceSubtype(int op) {
        if (op == 6) {
            return "Developer";
        }
        if (op == 7) {
            return "Tester";
        }
        if (op == 8) {
            return "Anayst";
        }
        if (op == 9) {
            return "Technician";
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