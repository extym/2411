package garber.models;

import java.io.Serializable;

public class Person  implements Serializable {

    private String login;
    private String pass;
    private int age;

    public Person(String login, String pass, int age) {
        this.login = login;
        this.pass = pass;
        this.age = age;
    }

    @Override
    public String toString() {
        return
                        "login' " + login + '\'' +
                        ", pass='" + pass + '\'' +
                        ", age=" + age;
    }
}
