package SignUp.Assignment3;

import com.sun.corba.se.impl.orbutil.graph.GraphImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private TableColumn distanceCol;
    @FXML
    private ComboBox maxDistance;
    @FXML
    private TextField lat;
    @FXML
    private TextField lon;
    @FXML
    private TextField dest;
    @FXML
    private TextArea directions;
    @FXML
    private TextField start;

    private BST<Restaurant> RestaurantList = new BST<>();
    private ObservableList<Restaurant> restaurantData = FXCollections.observableArrayList();
    private ExcelReader excel;
    private ObservableList<Restaurant> searchData = FXCollections.observableArrayList();
    private WeightedGraph<Restaurant> graph;
    private Heap<Restaurant> heap;

    GraphImpl map = new GraphImpl();



    private void populateListDist(ObservableList<Restaurant> temp) {
        table.setItems(temp);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        latCol.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        longCol.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        distanceCol.setCellValueFactory(new PropertyValueFactory<>("distance"));
        table.getColumns().setAll(nameCol, addressCol, cityCol, stateCol, zipCol, latCol, longCol, phoneCol, distanceCol);
    }

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
        table.getColumns().setAll(nameCol, addressCol, cityCol, stateCol, zipCol, latCol, longCol, phoneCol);
    }


    @FXML
    private void search(){
        if(keyword.getText().equals("")){
            populateList(restaurantData);
        }
        else{
            RestaurantResults(keyword.getText());
        }
    }

    @FXML
    private void findNearby()
    {

        if(lat.getText().isEmpty()||lon.getText().isEmpty())
        {
            populateList(restaurantData);
        }
        else {
            ArrayList<Restaurant> empty = new ArrayList<>();
            ObservableList<Restaurant> nearbyList = FXCollections.observableArrayList(empty);
//        if (searchData.isEmpty())
//        {
            // nearbyList = restaurantData;
//        }
//        else nearbyList = searchData;

            ArrayList<Restaurant> all = RestaurantList.extractValues(null);

            try {
                int max = Integer.parseInt(maxDistance.getValue().toString());

                for (int i = 0; i < all.size(); i++) {
                    Restaurant temp = all.get(i);
                    temp.setDistance(lat.getText(), lon.getText());
                    if (temp.getDistance() < max) {
                        nearbyList.add(all.get(i));
                    }
                }
            } catch (Exception e) {
                for (int i = 0; i < all.size(); i++) {
                    Restaurant temp = all.get(i);
                    temp.setDistance(lat.getText(), lon.getText());
                    if (!(temp.getDistance() == 100000.0)) {
                        nearbyList.add(all.get(i));
                    }

                }
            }
            populateListDist(nearbyList);
        }
    }

    @FXML
    private void findFastestRoute()
    {
        ArrayList<Restaurant> temp = RestaurantList.extractValues(null);
        Restaurant closest = temp.get(0);
        Restaurant destination = null;
        for (int i = 0;i <temp.size();i++) {
            if (temp.get(i).getName().equalsIgnoreCase(dest.getText()))
                destination = temp.get(i);
        }

        for (int i = 0;i <temp.size();i++)
        {
            temp.get(i).setDistancefromDest(destination.getLatitude(),destination.getLongitude());

            if (temp.get(i).getDistancefromDest()<closest.getDistancefromDest() && temp.get(i).getDistancefromDest()!=0)
                closest=temp.get(i);
        }

        directions.setText("The fastest route from " + start.getText() + " to " + destination.getName() + " is: \n" +
                "1. Start at " + start.getText() +
                "\n2. Than travel to " + closest.getName() +
                "\n3. And finally travel to " + destination.getName());


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
        searchData = restaurantResults;
    }




    private void storeData() {
        try {
            excel = new ExcelReader();
        } catch (IOException e) {
        }
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
            //  graph.addVertex(restaurant);
//            try {
//                heap.enqueue(restaurant);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
//        map.addAll(restaurantData);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        storeData();
        populateList(restaurantData);

    }
    public void initialize() throws IOException{

        storeData();
        populateList(restaurantData);
        keyword.setText("Search by any field");
    }
}
