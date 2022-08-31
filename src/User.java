public class User {

   private String userName;
   private String password;
   private String userType;
   private String name;


   
public User(String username, String password, String userType, String name) {
    this.userName = username;
    this.password = password;
    this.userType = userType;
    this.name = name;
}
public User() {
}


public String getUserName() {
    return userName;
}
public void setUserName(String name) {
    this.userName = name;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getUserType() {
    return userType;
}
public void setUserType(String userType) {
    this.userType = userType;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

   
}
