package FXUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


    public class StarterUI extends Application {

        public void start (Stage primaryStage) throws Exception{
            Parent parent= FXMLLoader.load(getClass().getResource("window.fxml"));
            primaryStage.setTitle("Тестовое окно");
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();

        }
    }
