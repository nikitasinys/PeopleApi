package dao;

import db.ConnectionFactory;
import logic.HashChecker;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean isExist(String login, String password) {

//        String ad = HashChecker.getHash("admin").toString();
//        String us = HashChecker.getHash("user").toString();
        if(login == null || password == null)
            return false;
        try ( Connection connection = ConnectionFactory.getConnection()){
              PreparedStatement preparedStatement = connection
                .prepareStatement(
//                        "update User set Password = ? where Login = ?"
                        "select Login, Password from \"User\" where Login = ? and Password = ?"
                );
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, HashChecker.getHash(password).toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                System.out.println("Login: " + resultSet.getString("login") + "\n"
                        + "Password: " + resultSet.getString("password"));
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Role getRoleByLoginPassword(String login, String password) {
        if(login == null || password == null)
            return (Role) null;
        Connection connection = ConnectionFactory.getConnection();
        try (PreparedStatement preparedStatement = connection
                .prepareStatement(
                        "select r.Name_role as \"Role\" from \"User\" u " +
                                "inner join Role r on u.Id_role=r.Id_role " +
                                "where u.Login = ? and u.Password = ?"
                )) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, HashChecker.getHash(password));

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                return Role.valueOf(resultSet.getString("Role").toUpperCase());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Role.DEFAULT;
    }
}
