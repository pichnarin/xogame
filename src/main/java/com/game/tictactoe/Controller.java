package com.game.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button HardBtn;

    @FXML
    private Button MediumBtn;

    @FXML
    private Button NormalBtn;

    private Stage stage = null;

    private Parent parent = null;

    //switch scene forwards and backwards
    @FXML
    public void onBtnClick(ActionEvent event){
        //switch to first_level.fxml
        try{
            if(event.getSource() == NormalBtn){
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("firstLevel.fxml")));
            }else if(event.getSource() == MediumBtn){
                stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secondLevel.fxml")));
            }else if(event.getSource() == HardBtn){
                stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("thirdLevel.fxml")));
            }

            assert parent != null;
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
