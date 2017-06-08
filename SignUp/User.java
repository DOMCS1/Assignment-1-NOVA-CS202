package SignUp;

import java.io.File;

/**
 * Created by Pratyush Gupta on 5/31/2017.
 */
public class User extends Person {

    private String username;
    private String email;
    private String  phone;
    private String password;
    private File pfp;

    public User(String first, String last, String ssn, String date, String gender, String username, String email, String phone, String password, File pfp)
    {
        super(first,last,ssn,date,gender);

        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.pfp = pfp;
    }

    public User(String first, String last, String date, String gender, String username,String password)
    {
        super(first,last,date,gender);
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public boolean passwordCorrect(String password)
    {
        return (password.equals(this.password));
    }

    public String toString()
    {
       return (getFullName() + ": " + username + " " + getDate() + " " + getGender() + " " + email + " " + phone + " " + password + " " + getSsn());
    }

    public String getPassword()
    {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public File getPfp()
    {
        return pfp;
    }

    public int compareTo(User compared)
    {
        return  this.username.compareTo(compared.username);
    }
}
