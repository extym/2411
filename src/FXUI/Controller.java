package FXUI;

import garber.models.Person;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;

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

    private void openFile(){
        FileChooser openFrame=new FileChooser();
        File file=openFrame.showOpenDialog(null);
        try {
            readFile(file);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void readFile(File file)throws IOException{
        //File file=new File("PersonTest.txt");
        if (file !=null)
            if (file.exists()){
            System.out.println("File"+file.getName()+ "Существует");
            FileReader fr=new FileReader(file);
            BufferedReader reader= new BufferedReader(fr);
            String line;
            int i;
            while ((line=reader.readLine()) !=null){
                System.out.println(line);
            }
            fr.close();
            reader.close();
        }else
            {
                file.createNewFile();
                FileWriter fr = new FileWriter(file, false);
                BufferedWriter writer = new BufferedWriter(fr);
                writer.write("Hello");
                writer.newLine();
                writer.write("xz");
                writer.newLine();
                writer.flush();
                writer.close();
                fr.close();

            }


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
