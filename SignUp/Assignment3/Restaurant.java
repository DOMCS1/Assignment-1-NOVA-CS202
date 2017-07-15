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
    private Image logo;
    private String city;
    private String state;
    private String zipcode;

    public Restaurant()
    {

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
       String toreturn = phone.charAt(0) + phone.substring(2, phone.length()-2);
       while (phone.length()<10)
       {
           toreturn = toreturn + "0";
       }
       return toreturn;
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
}
