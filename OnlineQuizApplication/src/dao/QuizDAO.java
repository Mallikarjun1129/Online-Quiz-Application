package dao;

import java.sql.*;
import java.util.*;
import model.Question;

public class QuizDAO {

    public List<Question> getQuestions(int quizId) {
        List<Question> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM questions WHERE quiz_id=?"
            );
            ps.setInt(1, quizId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                list.add(new Question(
                    rs.getInt("id"),
                    rs.getString("question"),
                    rs.getString("option1"),
                    rs.getString("option2"),
                    rs.getString("option3"),
                    rs.getString("option4"),
                    rs.getInt("correct_answer")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}