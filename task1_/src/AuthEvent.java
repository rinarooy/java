import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthEvent implements ActionListener {
    private JTextField jTextField;

    public AuthEvent(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hi!" + this.jTextField.getText());

    }
}
