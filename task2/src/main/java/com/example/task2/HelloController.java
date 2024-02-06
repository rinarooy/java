package com.example.task2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label resText;

    @FXML
    private TextField login;

    @FXML TextField password;
    @FXML
    private TextField email;

    @FXML TextField bYear;

    @FXML
    protected void onHelloButtonClick() {
        ServiceUser su = new ServiceUser(new UserDAOImplHibernate());

        if (su.signUp(login.getText(), password.getText(), Integer.valueOf(bYear.getText()), email.getText())){
            resText.setText("Success!!!!");
        }
        else{
            resText.setText("Good try but incorrect.");
        }
    }

    @FXML
    protected void onLoginButtonClick(){
        ServiceUser su = new ServiceUser(new UserDAOImplHibernate());

        if (su.signIn(login.getText(), password.getText())){
            resText.setText("Success!!!!");
        }
        else{
            resText.setText("Good try but incorrect.");
        }
    }
}