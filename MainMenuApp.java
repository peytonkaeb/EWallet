import javax.swing.*;
import java.awt.*;

public class MainMenuApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuApp::showMainMenu);
    }

    private static void showMainMenu() {
        JFrame frame = new JFrame("E-Wallet - Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JButton loginButton = new JButton("Login");
        JButton createUserButton = new JButton("Create User");

        loginButton.addActionListener(e -> {
            frame.dispose();
            showLoginScreen();
        });

        createUserButton.addActionListener(e -> {
            frame.dispose();
            showCreateUserScreen();
        });

        frame.add(loginButton);
        frame.add(createUserButton);
        frame.setVisible(true);
    }

    private static void showLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JTextField usernameInput = new JTextField();
        usernameInput.setMaximumSize(new Dimension(200, 25));

        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setMaximumSize(new Dimension(200, 25));

        JButton loginButton = new JButton("Login");
        JLabel feedbackLabel = new JLabel(" ");
        feedbackLabel.setForeground(Color.RED);

        loginButton.addActionListener(e -> {
            String username = usernameInput.getText().trim();
            String password = new String(passwordInput.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                feedbackLabel.setText("Please enter both username and password.");
            } else {
                // Instead of just launching EWalletApp.main, directly initialize the app with the user
                frame.dispose();

                // Pass the username and password to a method that starts EWalletApp with this user
                EWalletApp.startAppWithUser(username, password);
            }
        });

        panel.add(new JLabel("Username:"));
        panel.add(usernameInput);
        panel.add(new JLabel("Password:"));
        panel.add(passwordInput);
        panel.add(Box.createVerticalStrut(10));
        panel.add(loginButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(feedbackLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void showCreateUserScreen() {
        JFrame frame = new JFrame("Create User");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JTextField usernameInput = new JTextField();
        usernameInput.setMaximumSize(new Dimension(200, 25));

        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setMaximumSize(new Dimension(200, 25));

        JButton createButton = new JButton("Create Account");
        JLabel feedbackLabel = new JLabel(" ");
        feedbackLabel.setForeground(Color.BLUE);

        createButton.addActionListener(e -> {
            String username = usernameInput.getText().trim();
            String password = new String(passwordInput.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                feedbackLabel.setText("Username and password cannot be empty.");
            } else {
                // Simulate account creation (replace this with actual DB logic)
                feedbackLabel.setText("Account creation successful (simulated).");

                // Optionally, after successful creation, go back to main menu or auto-login
                // Here we go back to main menu after 2 seconds:
                Timer timer = new Timer(2000, ev -> {
                    frame.dispose();
                    showMainMenu();
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        panel.add(new JLabel("New Username:"));
        panel.add(usernameInput);
        panel.add(new JLabel("New Password:"));
        panel.add(passwordInput);
        panel.add(Box.createVerticalStrut(10));
        panel.add(createButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(feedbackLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
