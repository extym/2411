package FXUI;

import garber.models.Person;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {

    private Person pers;

    @FXML
    private Button regButton,exitButton;
    @FXML
    private TextField loginField,passField,ageField;

    @FXML private void initialize(){
        loginField.setText("Admin");
        passField.setText("1234");
        ageField.setText("22");

        initAction();
    }

    @FXML

    private void openFile()throws Exception{
        File file=new File("PersonTest.txt");
        if (file.exists()){
            System.out.println("File"+file.getName()+ "Существует");
            FileReader fr=new FileReader(file);
            BufferedReader reader= new BufferedReader(fr);
            String line;
            int i;
            while ((line=reader.readLine()) !=null){
                System.out.println(line);
            }
        }else
            file.createNewFile();


    }

    @FXML private void closeOperation(){
        System.exit(0);
    }
    private void  initAction(){

        regButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String login= loginField.getText();
                String pass=passField.getText();
                int age=Integer.valueOf(ageField.getText());

                pers=new Person(login,pass,age);

                Alert msg=new Alert(Alert.AlertType.CONFIRMATION, "Персона "+ pers+" Зарегистрирован");
                msg.showAndWait();
            }
        });
    }



}
