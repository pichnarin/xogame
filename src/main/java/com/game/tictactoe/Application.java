package com.game.tictactoe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("startUpITF.fxml"));
        stage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/512/566/566294.png"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 550);
        stage.setTitle("ticktacktoe");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}