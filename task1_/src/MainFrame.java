import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setSize(300, 300);
        setTitle("Авторизация");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(new AuthPanel());
    }
}
