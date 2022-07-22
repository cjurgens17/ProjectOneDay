package com.persistence;

import com.models.User;
import com.utils.ConnectionControl;
import com.utils.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.utils.ConnectionControl.connection;

public class UserDAO implements DAOInterface<User> {

    Connection connection;

    public UserDAO() {
        connection = ConnectionControl.getConnection();
    }


    @Override
    public Integer create(User user) {

        try {
            String sql = "INSERT INTO Users (user_id, username, pass_word, horoscope, mood, firstname) VALUES (DEFAULT,?,?,?,DEFAULT,?)";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

//            myStmt.setInt(1,user.getUserId());
            myStmt.setString(1, user.getUsername());
            myStmt.setString(2, user.getPassword());
            myStmt.setString(3, user.getHoroscope());
//            myStmt.setString(5,user.getMood());
            myStmt.setString(4,user.getFirstName());


            myStmt.executeUpdate();

            ResultSet rs = myStmt.getGeneratedKeys();

            rs.next();

            return rs.getInt("user_id");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;

    }

    @Override
    public User read(Integer id) {
        return null;
    }

    @Override
    public User update(User user) {

        try{
            String sql = "UPDATE Users SET mood=? WHERE user_id=?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getMood());
            pstmt.setInt(2,user.getUserId());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()){
                user.setMood(rs.getString("mood"));
            }

            return user;

        } catch (Exception e){
            System.out.println("Error in HoroscopeUserDAO update() method "+e.getMessage());
        }



        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public User loginUser(String username, String password) {

        try {
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement myStmt = connection.prepareStatement(sql);
            myStmt.setString(1,username);
            ResultSet rs = myStmt.executeQuery();

            if(rs.next() && rs.getString("pass_word").equals(password)){
                return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass_word"), rs.getString("horoscope"), rs.getString("mood"), rs.getString("firstname"));

            }


        } catch (Exception e) {
            System.out.println("This is the employeeDAO" + e.getMessage());
        }


        return new User();

    }
}
