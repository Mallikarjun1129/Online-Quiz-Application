package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import dao.*;
import model.*;

public class QuizFrame extends JFrame {

    List<Question> qList;
    int index = 0, score = 0;
    User user;
    int quizId;

    JLabel qLabel;
    JRadioButton o1, o2, o3, o4;
    ButtonGroup bg;

    public QuizFrame(int quizId, User user) {

        this.quizId = quizId;
        this.user = user;

        qList = new QuizDAO().getQuestions(quizId);

        setTitle("Quiz");

        JPanel panel = new JPanel();
        panel.setLayout(null);

        qLabel = new JLabel();
        qLabel.setBounds(50, 30, 400, 30);

        o1 = new JRadioButton();
        o2 = new JRadioButton();
        o3 = new JRadioButton();
        o4 = new JRadioButton();

        o1.setBounds(50, 80, 300, 30);
        o2.setBounds(50, 120, 300, 30);
        o3.setBounds(50, 160, 300, 30);
        o4.setBounds(50, 200, 300, 30);

        bg = new ButtonGroup();
        bg.add(o1); bg.add(o2); bg.add(o3); bg.add(o4);

        JButton next = new JButton("Next");
        next.setBounds(50, 250, 100, 30);

        panel.add(qLabel);
        panel.add(o1); panel.add(o2); panel.add(o3); panel.add(o4);
        panel.add(next);

        add(panel);

        load();

        next.addActionListener(e -> check());

        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void load() {
        Question q = qList.get(index);
        qLabel.setText(q.getQuestion());
        o1.setText(q.getO1());
        o2.setText(q.getO2());
        o3.setText(q.getO3());
        o4.setText(q.getO4());
        bg.clearSelection();
    }

    void check() {
        Question q = qList.get(index);

        int sel = 0;
        if (o1.isSelected()) sel = 1;
        if (o2.isSelected()) sel = 2;
        if (o3.isSelected()) sel = 3;
        if (o4.isSelected()) sel = 4;

        if (sel == q.getCorrect()) score++;

        index++;

        if (index < qList.size()) {
            load();
        } else {
            JOptionPane.showMessageDialog(this, "Final Score: " + score);
            new ResultDAO().saveResult(user.getId(), quizId, score);
        }
    }
}