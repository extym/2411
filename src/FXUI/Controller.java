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
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Person pers;
    private List<Person> list=new ArrayList<>();

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
//        try {
//            serialise();
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        FileChooser openFrame=new FileChooser();
        File file=openFrame.showOpenDialog(null);
        try {
            deserialise(file);
            //readFile(file);
        } catch (Exception e) {
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
                list.add(pers);

                Alert msg=new Alert(Alert.AlertType.CONFIRMATION, "Персона "+ pers+" Зарегистрирован");
                msg.showAndWait();
            }
        });
    }

    private void  serialise() throws IOException {
        FileOutputStream fos=new FileOutputStream("testtest.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.flush();
        oos.close();
        fos.close();
    }
     private  void  deserialise(File file)throws Exception{
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);
        List<Person> personList=(List<Person>) ois.readObject();
        ois.close();
        fis.close();
        for (Person person:personList) {

            System.out.println(person);
        }
     }
}
