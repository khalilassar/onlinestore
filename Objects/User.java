package soeq.app.soeq.Objects;

public class User {
    private int User_id;
    private String user_name;
    private String u_password;
    private String first_name;
    private String last_name;
    private String email;
    private String phon_number;

    public User(int User_id,String user_name, String u_password, String first_name, String last_name, String email, String phon_number) {
        this.user_name = user_name;
        this.u_password = u_password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phon_number = phon_number;
        this.User_id = User_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhon_number() {
        return phon_number;
    }

    public void setPhon_number(String phon_number) {
        this.phon_number = phon_number;
    }
}
