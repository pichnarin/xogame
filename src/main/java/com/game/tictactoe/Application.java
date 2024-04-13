package com.game.tictactoe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        try{
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startUpITF.fxml")));
            stage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/512/566/566294.png"));
            Scene scene = new Scene(parent, 900, 550);
            stage.setTitle("ticktacktoe");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}