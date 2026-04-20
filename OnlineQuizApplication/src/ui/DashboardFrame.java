package ui;

import javax.swing.*;
import java.awt.*;
import model.User;

public class DashboardFrame extends JFrame {

    public DashboardFrame(User u) {

        setTitle("Dashboard");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Select Quiz");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(100, 20, 200, 30);

        JButton apt = new JButton("Aptitude Quiz");
        JButton java = new JButton("Java Quiz");

        apt.setBounds(80, 80, 150, 40);
        java.setBounds(80, 140, 150, 40);

        panel.add(title);
        panel.add(apt);
        panel.add(java);

        add(panel);

        apt.addActionListener(e -> new QuizFrame(1, u));
        java.addActionListener(e -> new QuizFrame(2, u));

        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}