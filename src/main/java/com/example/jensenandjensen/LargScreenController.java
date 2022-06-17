package com.example.jensenandjensen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LargScreenController implements Initializable {
    @FXML
    private TableColumn<Consultants, String> cn_col_LS;

    @FXML
    private TableColumn<Consultants, String> status_col_LS;

    @FXML
    private TableView<Consultants> tblV_LScreen;
    Stage stage=new Stage();
    String query;
    public Connection conn=null;
    public PreparedStatement ps;
    public ResultSet rs;
    DBconnection DB=new DBconnection();

    //method to initialize the table view of consultant status
    public void iniLargScreenTable(){
        cn_col_LS.setCellValueFactory(new PropertyValueFactory<Consultants,String>("firstName"));
        status_col_LS.setCellValueFactory(new PropertyValueFactory<Consultants,String>("Status"));

    }
    ObservableList<Consultants> consultantStatusList= FXCollections.observableArrayList(
     );
    //tblV_LScreen.getItems().get(i).getStatus().equals("active")
    public void getColor(){


        for (int i = 0; i < tblV_LScreen.getItems().size(); i++) {
            if(tblV_LScreen.getItems().get(i).getStatus().equals("active"))
            {
                status_col_LS.setStyle("-fx-text-fill: green;");
                //status_col_LS.getColumns().get(i).getStyle();

             }else{
                if(tblV_LScreen.getItems().get(i).getStatus().equals("inactive"))
                {
                    status_col_LS.setStyle("-fx-text-fill: red;");
                } } }
    }
    //get consultant status from database
    public void loadStatusFromDataBase() {
        //consultantList.clear();
        conn= DB.getConnection();

        try {

            query = "SELECT * FROM consultant";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                consultantStatusList.add(new Consultants(

                         rs.getString("FirstName"),
                         rs.getString("Status")
                ));

                tblV_LScreen.setItems(consultantStatusList);
                tblV_LScreen.getItems().addAll();

            }


        } catch (SQLException ex) {
            ex.getMessage();
        }  }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniLargScreenTable();
        loadStatusFromDataBase();
        tblV_LScreen.setItems(consultantStatusList);
        tblV_LScreen.getItems().addAll();
        getColor();

    }
}
