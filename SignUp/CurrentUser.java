package SignUp;

/**
 * Created by Pratyush Gupta on 6/7/2017.
 */
public class CurrentUser {

    private static String fullname;
    private static String username;
    private static String email;
    private static String date;
    private static String gender;
    private static String phone;

    public CurrentUser(User current)
    {
        this.fullname = current.getFullName();
        this.username = current.getUsername();
        this.email = current.getEmail();
        this.date = current.getDate();
        this.gender = current.getGender();
        this.phone = current.getPhone();

    }

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        CurrentUser.fullname = fullname;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentUser.username = username;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        CurrentUser.email = email;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        CurrentUser.date = date;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        CurrentUser.gender = gender;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        CurrentUser.phone = phone;
    }
}
