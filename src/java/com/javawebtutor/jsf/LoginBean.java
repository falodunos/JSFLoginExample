/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebtutor.jsf;

/**
 *
 * @author Olugbenga.Falodun
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    private String userName;
    private String password;
    private String dbuserName;

    private String dbpassword;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;

    /**
     * Returns username
     * @return String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set username
     * @param userName String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns user password
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set user password
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the database username
     * @return String
     */
    public String getDbuserName() {
        return dbuserName;
    }

    /**
     * Set the database username
     * @param dbuserName String
     */
    public void setDbuserName(String dbuserName) {
        this.dbuserName = dbuserName;
    }

    /**
     * Set the database password
     * @return String
     */
    public String getDbpassword() {
        return dbpassword;
    }

    /**
     * Set database password
     * @param dbpassword String
     */
    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    /**
     * Establish database connection and execute query
     * @param userName String
     */
    public void dbData(String userName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jwt", "root", "pa55w0rd");
            statement = connection.createStatement();
            SQL = "Select * from USER_DETAIL where username like ('" + userName + "')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbuserName = resultSet.getString(1).toString();
            dbpassword = resultSet.getString(2).toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }

    /**
     * Check if user is valid
     * @return String
     */
    public String checkValidUser() {
        dbData(userName);

        if (userName.equalsIgnoreCase(dbuserName)) {

            if (password.equals(dbpassword)) {
                return "success";
            } else {
                return "failure";
            }
        } else {
            return "failure";
        }
    }
}
