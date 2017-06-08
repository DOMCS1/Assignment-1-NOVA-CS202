package SignUp;

import java.util.Date;

/**
 * Created by Pratyush Gupta on 5/31/2017.
 */
public class Person {

    private String first;
    private String last;
    private String ssn;
    private String date;
    private int gender; //0 = female, 1 = male

    public Person( String first, String last, String ssn, String date, String gender) {
        this.first = first;
        this.last = last;
        this.ssn = ssn;
        if (gender.equalsIgnoreCase("female"))
            this.gender = 0;
        else
            this.gender = 1;

        this.date = date;



    }

    public Person( String first, String last, String date, String gender) {
        this.first = first;
        this.last = last;
        if (gender.equalsIgnoreCase("female"))
            this.gender = 0;
        else
            this.gender = 1;

        this.date = date;
    }

    public Person()
    {
        Date dob = new Date();
        date = dob.toString().substring(4,10) + dob.toString().substring(25);
    }



    public void setDate(String date) {
        this.date = date;


    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("female"))
            this.gender = 0;
        else
            this.gender = 1;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getGender() {
        if (gender == 0)
            return "female";
        else
            return "male";
    }


    public String getSsn() {
        return ssn;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getFullName()
    {
        return first + " " + last;
    }

    public String getDate() {
        return date;
    }
}
