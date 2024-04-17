package com.game.tictactoe;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.URL;
import java.util.*;

public class NormalLevelController implements Initializable {
    @FXML
    private Button BackToMain;

    private Stage stage = null;

    private Parent parent = null;

    @FXML
    private Button btn1Normal;

    @FXML
    private Button btn2Normal;

    @FXML
    private Button btn3Normal;

    @FXML
    private Button btn4Normal;

    @FXML
    private Button btn5Normal;

    @FXML
    private Button btn6Normal;

    @FXML
    private Button btn7Normal;

    @FXML
    private Button btn8Normal;

    @FXML
    private Button btn9Normal;

    @FXML
    private TextField oPoint;

    @FXML
    private TextField playerMenu;

    @FXML
    private Button resetButton;

    @FXML
    private TextField xPoint;


    int xScore = 0;

    int oScore = 0;

    int playerTurn = 0;

    String line;

    ArrayList<Button> normalLevelButton;

    //backwards scene to main
    public void onBtnClick(ActionEvent event){
        try{
            if(event.getSource() == BackToMain){
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startUpITF.fxml")));
            }
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void setPlayerSymbol(Button button) {
        if (playerTurn % 2 == 0) {
            playerMenu.setText("O turn!");
            button.setText("X");
            playerTurn = 1;
        }else{
            playerMenu.setText("X turn!");
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void disableAllBtn() {
        normalLevelButton.forEach(button -> button.setDisable(true));
    }


    public void CheckForPossibleWin() {
        boolean gameWon = false;
        for (int i = 0; i < 8; i++) {
            line = switch (i) {
                case 0 -> btn1Normal.getText() + btn2Normal.getText() + btn3Normal.getText();
                case 1 -> btn4Normal.getText() + btn5Normal.getText() + btn6Normal.getText();
                case 2 -> btn7Normal.getText() + btn8Normal.getText() + btn9Normal.getText();
                case 3 -> btn1Normal.getText() + btn4Normal.getText() + btn7Normal.getText();
                case 4 -> btn2Normal.getText() + btn5Normal.getText() + btn8Normal.getText();
                case 5 -> btn3Normal.getText() + btn6Normal.getText() + btn9Normal.getText();
                case 6 -> btn1Normal.getText() + btn5Normal.getText() + btn9Normal.getText();
                case 7 -> btn3Normal.getText() + btn5Normal.getText() + btn7Normal.getText();
                default -> null;
            };

            if (line.equals("XXX")) {
                playerMenu.setText("X won!");
                xScore++;
                xPoint.setText(String.valueOf(xScore));
                gameWon = true;
            } else if (line.equals("OOO")) {
                playerMenu.setText("O won!");
                oScore++;
                oPoint.setText(String.valueOf(oScore));
                gameWon = true;
            }
        }
        if (gameWon) {
            disableAllBtn(); // Disable buttons if the game has been won
        }
    }


    public void GameSetUp(Button button) {
        button.setOnMouseClicked(_ -> {
            button.setTextFill(Color.WHITE);
            setPlayerSymbol(button);
            button.setDisable(true);
            CheckForPossibleWin();
        });
    }

    public void ResetGame(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    @FXML
    public void ResetScoreButton(ActionEvent event){
        if(event.getSource() == resetButton){
            xPoint.clear();
            oPoint.clear();
        }
    }

    @FXML
    public void RestartGameButton() {
        normalLevelButton.forEach(this::ResetGame);
        playerMenu.setText("Welcome to tic-tac-toe!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        normalLevelButton = new ArrayList<>(Arrays.asList(
                btn1Normal, btn2Normal, btn3Normal,
                btn4Normal, btn5Normal, btn6Normal,
                btn7Normal, btn8Normal, btn9Normal
        ));
        normalLevelButton.forEach(this::GameSetUp);
        playerMenu.setText("Welcome to tic-tac-toe!");
    }
}
