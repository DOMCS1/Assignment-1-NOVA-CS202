package SignUp;

import SignUp.Assignment2.IndexedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    @FXML
    private TextField first;@FXML
    private TextField last;@FXML
    private TextField ssn;@FXML
    private TextField username;@FXML
    private TextField email;@FXML
    private TextField pass1;@FXML
    private TextField pass2;@FXML
    private TextField dob;@FXML
    private TextField gender;@FXML
    private TextField phone;@FXML
    private TextField usernameattempt;@FXML
    private TextField passwordattempt;@FXML
    private Button loginbtn; @FXML
   /* private Label profilefullname; @FXML
    private Label profileusername; @FXML
    private ImageView profilepfp;@FXML
    private Label profileemail;@FXML
    private Label profiledob;@FXML
    private Label profileGender;@FXML
    private Label profilePhone;*/
    private File pfp;

    private static IndexedList<User> users = new IndexedList();
    //private static ArrayList<User> users = new ArrayList();

    public void signup() throws Exception
    {
        for(int i = 0; i<users.size();i++)
        {
            if(users.get(i).getUsername().equals(username.getText())) {
                username.setText("Error: Username taken");
            }
        }

        if(!username.getText().equals("Error: Username taken")) {
            if (!(first.getText().equals("") || last.getText().equals("") || dob.getText().equals("") || gender.getText().equals("") || username.getText().equals(""))) {
                if (pass1.getText().equals(pass2.getText())) {
                    if (email.getText().length() == 0 || (email.getText().indexOf('@') > 0) && (email.getText().substring(email.getText().indexOf("@")).indexOf('.') > 0)) {
                        if (!((pass1.getText().equals(pass1.getText().toUpperCase())) || (pass2.getText().equals(pass1.getText().toLowerCase())))) {
                            if (pass1.getText().matches(".*\\d.*")) {
                                if (!pass1.getText().matches("[^A-Za-z0-9]")) {
                                    User next = new User(first.getText(), last.getText(), ssn.getText(), dob.getText(), gender.getText(), username.getText(), email.getText(), phone.getText(), pass1.getText(), pfp);
                                    users.add(next);
                                    //System.out.print(users);
                                    Stage primaryStage = new Stage();
                                    Parent root = FXMLLoader.load(getClass().getResource("/SignUp/Login.fxml"));
                                    primaryStage.setTitle("Login");
                                    primaryStage.setScene(new Scene(root, 600, 400));
                                    primaryStage.show();
                                } else {
                                    pass1.setText("MUST contain one special character");
                                }
                            } else {
                                pass1.setText("MUST contain one digit");
                            }

                        } else {
                            pass1.setText("MUST contain one lowercase and uppercase letter");
                        }

                    } else
                        email.setText("MUST BE CORRECT FORMAT");
                } else
                {
                    pass1.setText("MUST MATCH");
                    pass2.setText("MUST MATCH");
                }
            } else {
                first.setText("REQUIRED");
                last.setText("REQUIRED");
                dob.setText("REQUIRED");
                gender.setText("REQUIRED");
                username.setText("REQUIRED");
            }
        }

    }


 /*   public ArrayList<User> addToUsers(User test)
    {
        users.add(test);
         return users;
    }*/


    //@FXML
    public void locateFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        pfp = chooser.showOpenDialog(new Stage());
    }

    public void alreadyRegistered() throws Exception
    {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/SignUp/Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public void login() throws Exception
    {
        User match = null;
        //System.out.print(users);
        for (int j = 0; j<users.size(); j++)
        {
            if (users.get(j).getUsername().equals(usernameattempt.getText()))
            {
                if(users.get(j).getPassword().equals(passwordattempt.getText())) {

                    //CurrentUser test = new CurrentUser(users.get(j));
                    System.out.print(users.get(j));
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/SignUp/Assignment3/RestaurantView.fxml"));
                    primaryStage.setTitle("Restaurant View");
                    primaryStage.setScene(new Scene(root, 900, 800));
                    primaryStage.show();


                    /*try {
                        Image image = javafx.scene.image.Image.impl_fromPlatformImage(ImageIO.read(pfp));
                        profilepfp.setImage(image);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                    this.username = current.getUsername();
                    this.email = current.getEmail();
                    this.date = current.getDate();
                    this.gender = current.getGender();
                    this.phone = current.getPhone();
                    profilefullname.setText(test.getFullname());
                    profileusername.setText(test.getUsername());
                    profileemail.setText("Email: " + test.getEmail());
                    profiledob.setText("DOB: " + test.getDate());
                    profileGender.setText(test.getGender());
                    profilePhone.setText(test.getPhone());
                    test.setFullname(users.get(j).getFullName());*/


                }

            }
        }
        if (match == null)
        {
            loginbtn.setText("Login Attempt failed! Try Again?");
        }



    }



}
