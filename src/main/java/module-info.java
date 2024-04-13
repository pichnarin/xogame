module com.game.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.game.tictactoe to javafx.fxml;
    exports com.game.tictactoe;
}