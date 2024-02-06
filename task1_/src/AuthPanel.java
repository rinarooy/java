import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthPanel extends JPanel {
    public AuthPanel() {
        JLabel titleLabel = new JLabel("Авторизация");
        JLabel loginLabel = new JLabel("введите логин");
        JLabel passwordLabel = new JLabel("введите пароль");
        JTextField loginTexfield = new JTextField(20);
        JTextField passwordTexfield = new JTextField(20);
        JButton authButton = new JButton("войти");
        JLabel outLabel = new JLabel();

        add(titleLabel);
        JPanel loginPanel = new JPanel();
        loginPanel.add(loginLabel);
        loginPanel.add(loginTexfield);
        add(loginPanel);
        add(passwordLabel);
        add(passwordTexfield);
        add(authButton);
        add(outLabel);

        authButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceUser sU = new ServiceUser(new JDBCPostgres());
                if (sU.signIn(loginTexfield.getText(), passwordTexfield.getText())) {
                    System.out.println("Hi!" + loginTexfield.getText());
                    outLabel.setText("Hi!" + loginTexfield.getText());
                }
                else{
                    outLabel.setText("Такого пользователя не существует" );
                }

            }
        });
    }
}
