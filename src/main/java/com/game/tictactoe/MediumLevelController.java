package com.game.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MediumLevelController implements Initializable {
    @FXML
    private Button BackToMain;

    private Stage stage = null;

    private Parent parent = null;

    //backwards scene to main
    @FXML
    public void onBtnClick(ActionEvent event){
        try{
            if(event.getSource() == BackToMain){
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startUpITF.fxml")));
            }
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
