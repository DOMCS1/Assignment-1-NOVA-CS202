package SignUp.Assignment3;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Pratyush Gupta on 6/30/2017.
 */
public class Restaurant implements Comparable {

    private String name;
    private String address;
    private String longitude;
    private String latitude;
    private String phone;
    private String city;
    private String state;
    private String zipcode;
    private double distance;
    private double distancefromDest;
    private Image logo;

    public Restaurant()
    {
        distance = 100000.0;
        distancefromDest = 100000;
    }
    public Restaurant(String name, String address, String longitude, String latitude, String phone, Image logo)
    {
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.logo = logo;
    }

    public Restaurant(String name, String address, String longitude, String latitude)
    {
        this.name = name;
        this.address = address;
        this. longitude = longitude;
        this.latitude = latitude;
        this.phone = "9999999999";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }


    public void setDistancefromDest(String lat, String lon) {
        Double latinput = Double.parseDouble(lat);
        Double loninput = Double.parseDouble(lon);
        Double latorig = Double.parseDouble(latitude);
        Double lonorig = Double.parseDouble(longitude);

        Double latDistance = toRad(latinput-latorig);
        Double lonDistance = toRad(loninput-lonorig);




        Double a = Math.sin(latDistance / 2) *
                Math.sin(latDistance / 2) +
                Math.cos(toRad(latinput)) *
                        Math.cos(toRad(latorig)) *
                        Math.sin(lonDistance / 2) *
                        Math.sin(lonDistance / 2);


        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        this.distancefromDest = 3959 * c;


    }

    public void setDistance(String lat, String lon)
    {
    Double latinput = Double.parseDouble(lat);
        Double loninput = Double.parseDouble(lon);
        Double latorig = Double.parseDouble(latitude);
        Double lonorig = Double.parseDouble(longitude);

        Double latDistance = toRad(latinput-latorig);
        Double lonDistance = toRad(loninput-lonorig);
        Double a = Math.sin(latDistance / 2) *
                Math.sin(latDistance / 2) +
                Math.cos(toRad(latinput)) *
                        Math.cos(toRad(latorig)) *
                        Math.sin(lonDistance / 2) *
                        Math.sin(lonDistance / 2);


        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        this.distance = 3959 * c;



    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLocation(String latitude, String longitude)
    {
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public String getLocation()
    {
        return "(" + latitude + ", " + longitude + ")";
    }

    public String getPhone() {
        return phone.charAt(0) + phone.substring(2, phone.length()-2);

    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public ImageView getLogo() {
//        ImageView image = new ImageView();
//        Image images = SwingFXUtils.toFXImage(logo,null);
//        image.setImage((images));
//        return image;
//    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void setLogo(String url) throws IOException {

        WritableImage test = new WritableImage(100, 100);
        try {
            try {
                URL Url = new URL(url);
                BufferedImage image = ImageIO.read(Url);
                logo = SwingFXUtils.toFXImage(image, test);

            } catch (IOException e) {
                URL URL = new URL("http://vignette2.wikia.nocookie.net/pandorahearts/images/a/ad/Not_available.jpg/revision/latest?cb=20141028171337");
                BufferedImage image = ImageIO.read(URL);

                logo = SwingFXUtils.toFXImage(image, test);
            }
        } catch (Exception e){}


    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode.substring(0,5);
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode.substring(0,5);
    }

    public int compareTo(Restaurant o) {
        return (int) (100*((Double.parseDouble(longitude) - Double.parseDouble(o.getLongitude()))));
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String toString()
    {
        return name + state + address + zipcode + city;
    }

    public double getDistancefromDest() {
        return distancefromDest;
    }
}
