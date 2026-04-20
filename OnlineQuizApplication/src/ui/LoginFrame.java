package ui;

import javax.swing.*;
import java.awt.*;
import dao.UserDAO;
import model.User;

public class LoginFrame extends JFrame {

    JTextField user;
    JPasswordField pass;

    public LoginFrame() {

        setTitle("Online Quiz Login");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 144, 255));

        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setBounds(120, 20, 100, 30);

        JLabel uLabel = new JLabel("Username:");
        uLabel.setBounds(50, 80, 100, 25);
        uLabel.setForeground(Color.WHITE);

        user = new JTextField();
        user.setBounds(150, 80, 150, 25);

        JLabel pLabel = new JLabel("Password:");
        pLabel.setBounds(50, 120, 100, 25);
        pLabel.setForeground(Color.WHITE);

        pass = new JPasswordField();
        pass.setBounds(150, 120, 150, 25);

        JButton login = new JButton("Login");
        JButton register = new JButton("Register");

        login.setBounds(70, 180, 100, 30);
        register.setBounds(180, 180, 100, 30);

        panel.add(title);
        panel.add(uLabel);
        panel.add(user);
        panel.add(pLabel);
        panel.add(pass);
        panel.add(login);
        panel.add(register);

        add(panel);

        login.addActionListener(e -> {
            User u = new UserDAO().login(
                    user.getText(),
                    new String(pass.getPassword())
            );

            if (u != null) {
                new DashboardFrame(u);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }
        });

        register.addActionListener(e -> new RegisterFrame());

        setSize(350, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}