/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
//jdbc:oracle:thin:@dilbert.humber.ca:1521:grok

/**
 *
 * @author ruz
 */
public class DbConnect {

    public static void main(String[] args) {
        try {
            String url = "jdbc:oracle:thin:@dilbert.humber.ca:1521:grok";
            /**
             * To include driver for SQL DEVELOPER
             */
            Class.forName("oracle.jdbc.driver.OracleDriver");
            /**
             * To include driver for SQL DEVELOPER
             */
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Found");
            /**
             * To establish connection
             */
            Connection con = DriverManager.getConnection(url, "N01165469", "oracle");
            System.out.println("Connection Established");
            /**
             * To create statement to make connection running
             */
            Statement stmt = con.createStatement();
            System.out.println("Statement Object is ready");
            ResultSet rs = stmt.executeQuery("select * from login");
            while (rs.next()) {
                System.out.println(rs.getString(1).toString());
                System.out.println(rs.getString(2).toString());
            }
            System.out.println("Good bye");
            rs.close();
            con.close();

        } catch (SQLException | ClassNotFoundException objSql) {
            System.out.println("Driver Not Found");
        }

    }
}
