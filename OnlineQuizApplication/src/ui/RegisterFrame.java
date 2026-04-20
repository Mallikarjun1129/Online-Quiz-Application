package ui;

import javax.swing.*;
import dao.UserDAO;
import model.User;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton btn = new JButton("Register");

        setLayout(null);

        user.setBounds(50,50,200,30);
        pass.setBounds(50,100,200,30);
        btn.setBounds(50,150,120,30);

        add(user); add(pass); add(btn);

        btn.addActionListener(e->{
            new UserDAO().register(
                new User(user.getText(), new String(pass.getPassword()))
            );
            JOptionPane.showMessageDialog(this,"Registered");
            dispose();
        });

        setSize(300,250);
        setVisible(true);
    }
}