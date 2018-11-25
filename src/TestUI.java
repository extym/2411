import garber.models.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestUI extends JFrame{

    JButton regButton=new JButton("Регистрация");
    JButton exitButton=new JButton("Выход");
    JPanel buttPanel=new JPanel();

    JLabel label1=new JLabel("Логин");
    JLabel label2=new JLabel("Пароль");
    JLabel label3=new JLabel("Возраст");

    JTextField loginField=new JTextField("login");
    JTextField passField=new JTextField("password");
    JTextField ageField=new JTextField("age");

     JPanel fieldsPanel=new JPanel();

     Person pers;

        public TestUI(String title, int w, int h){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         setTitle(title);
         setSize(w,h);

         fieldsPanel.setLayout(new GridLayout(3,2));
         fieldsPanel.add(label1,0,0);
         fieldsPanel.add(ageField,0,1);
         fieldsPanel.add(label2,1,0);
         fieldsPanel.add(passField,1,1);
         fieldsPanel.add(label3,2,0);
         fieldsPanel.add(loginField,2,1);
         buttPanel.add(exitButton);
         buttPanel.add(regButton);

        // buttPanel.add(regButton);
        // buttPanel.add(exitButton);
         add(buttPanel, BorderLayout.SOUTH);
         add(fieldsPanel,BorderLayout.CENTER);
         pack();
         setSize(w,h);

         initActions();

     }

     private void initActions(){
            regButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String login=loginField.getText();
                    String pass=passField.getText();
                    int age=Integer.parseInt(ageField.getText());
                    pers=new Person(login,pass,age);
                    JOptionPane.showMessageDialog(null, "Персона " +pers+"  Зарегистрирован");

                }
            });

     }

    public static void main(String[] args) {
        new TestUI("Тестовая форма", 250, 150).setVisible(true);
    }

}

