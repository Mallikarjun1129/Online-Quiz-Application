package dao;

import java.sql.*;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    public boolean register(User user) {
        try {
            Connection con = DBConnection.getConnection();
            String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username,password) VALUES(?,?)"
            );
            ps.setString(1, user.getUsername());
            ps.setString(2, hashed);
            ps.executeUpdate();
            return true;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User login(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=?"
            );
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                if(BCrypt.checkpw(password, rs.getString("password"))) {
                    return new User(rs.getInt("id"), username, password);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}