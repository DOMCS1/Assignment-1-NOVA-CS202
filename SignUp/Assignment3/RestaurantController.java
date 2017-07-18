package SignUp.Assignment3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Pratyush Gupta on 7/8/2017.
 */
public class RestaurantController implements Initializable {

    @FXML
    private TableView<Restaurant> table;
    @FXML
    private TextField keyword;
    @FXML
    private Button searchButton;
    @FXML
    private TableColumn nameCol;
    @FXML
    private TableColumn addressCol;
    @FXML
    private TableColumn cityCol;
    @FXML
    private TableColumn stateCol;
    @FXML
    private TableColumn zipCol;
    @FXML
    private TableColumn latCol;
    @FXML
    private TableColumn longCol;
    @FXML
    private TableColumn phoneCol;
    @FXML
    private TableColumn imageCol;

    private BST<Restaurant> RestaurantList = new BST<>();
    private ObservableList<Restaurant> restaurantData = FXCollections.observableArrayList();
    private ExcelReader excel;


    private void populateList(ObservableList<Restaurant> temp) {
        table.setItems(temp);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        latCol.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        longCol.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        imageCol.setCellValueFactory(new PropertyValueFactory<>("logo"));
        table.getColumns().setAll(nameCol, addressCol, cityCol, stateCol, zipCol, latCol, longCol, phoneCol, imageCol);
    }


    @FXML
    private void search(){


        if(keyword.getText().equals("")){
            populateList(restaurantData);
            searchButton.setText("New Search");
        }
        else{
            RestaurantResults(keyword.getText());
        }
    }
    
    private void RestaurantResults(String keyword){

        ObservableList<Restaurant> restaurantResults = FXCollections.observableArrayList();

        restaurantResults.clear();

        ArrayList<Restaurant> data;

        BSTNode n = null;

        data = RestaurantList.extractValues(n);


        for(int i = 0; i < data.size(); i++)
        {
            Restaurant temp = data.get(i);
            if (temp.getName().contains(keyword))
            {
                restaurantResults.add(temp);
            }
           else if (temp.getAddress().contains(keyword))
            {
                restaurantResults.add(temp);
            }
            else if (temp.getLongitude().contains(keyword))
            {
                restaurantResults.add(temp);
            }
            else if (temp.getLatitude().contains(keyword))
            {
                restaurantResults.add(temp);
            }
            else if (temp.getPhone().contains(keyword))
            {
                restaurantResults.add(temp);
            }
            else if (temp.getCity().contains(keyword))
            {
                restaurantResults.add(temp);
            }
            else if (temp.getState().contains(keyword))
            {
                restaurantResults.add(temp);
            }
            else if (temp.getZipcode().contains(keyword))
            {
                restaurantResults.add(temp);
            }
        }

        populateList(restaurantResults);


    }

    private void storeData() throws IOException{
//        try {
        excel = new ExcelReader();
//        } catch (IOException e) {
//        }
        List restaurantList = excel.getList();
        for (int row = 0; row < ((List)restaurantList.get(0)).size(); row++) {
            List list = (List) restaurantList.get(0);
            Restaurant restaurant = new Restaurant();
            restaurant.setName(String.valueOf(list.get(row)));
            list = (List) restaurantList.get(1);

            restaurant.setAddress(String.valueOf(list.get(row)));
            list = (List) restaurantList.get(2);

            restaurant.setCity(String.valueOf(list.get(row)));
            list = (List) restaurantList.get(3);

            restaurant.setState(String.valueOf(list.get(row)));
            list = (List) restaurantList.get(4);

            restaurant.setZipcode(String.valueOf(list.get(row)));
            list = (List) restaurantList.get(5);

            restaurant.setLatitude(String.valueOf(list.get(row)));
            list = (List) restaurantList.get(6);

            restaurant.setLongitude(String.valueOf(list.get(row)));
            list = (List) restaurantList.get(7);

            restaurant.setPhone(String.valueOf(list.get(row)));
            // = (List) restaurantList.get(8);

//            try {
//                restaurant.setLogo(String.valueOf(list.get(row)));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            restaurantData.add(restaurant);
            RestaurantList.add(restaurant);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            storeData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        populateList(restaurantData);

    }
    public void initialize() throws IOException{

        storeData();
        populateList(restaurantData);


    }
}
