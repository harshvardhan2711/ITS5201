/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbuttonapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruz
 */
public class JavaFxButtonApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label lblUsername = new Label();
        lblUsername.setText("Username : ");
        lblUsername.setId("txtlblUsername");

        TextField txtUsername = new TextField();
        txtUsername.setPromptText("Enter Username");
        txtUsername.setId("txtUsername");

        Label lblPassword = new Label();
        lblPassword.setText("Password : ");
        lblPassword.setId("lblPassword");

        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Enter Password");
        txtUsername.setId("txtUsername");

        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setId("btnOk");
        btnOk.setOnAction((ActionEvent event) -> {
            boolean response = authenticateUser(txtUsername.getText(), txtPassword.getText());
            System.out.println(response);
        });

        /**
         * Instead of using setTextwe can also set text using Button
         * test_button=newButton("test button");
         */
        Button btnExit = new Button("Exit");
        btnExit.setId("btnExit");
        /**
         * Mutable events using lambda expression
         */
        btnExit.setOnAction((ActionEvent e) -> {
            System.exit(0);

        });

        //StackPane sp = new StackPane();
        HBox hb = new HBox();
        hb.setSpacing(10);

        //VBox vb = new VBox();
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(20));
        /*sp.getChildren().add(txtEmail);
        sp.getChildren().add(btnOk);
        sp.getChildren().add(btnExit);*/
        hb.getChildren().add(btnOk);
        hb.getChildren().add(btnExit);

        gp.add(lblUsername, 0, 0);
        gp.add(txtUsername, 1, 0);
        gp.add(lblPassword, 0, 1);
        gp.add(txtPassword, 1, 1);
        gp.add(hb, 1, 2);

        Scene scene = new Scene(gp, 500, 250);

        primaryStage.setTitle("Java Fx Buttom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    public static boolean authenticateUser(String username, String password) {
        boolean result = false;
        try {
            Statement stmt = getConnectionString().createStatement();
            ResultSet rs = stmt.executeQuery("select login_id,username,password from login where lower(username)='" + username + "' and lower(password)='" + password + "'");
            while (rs.next()) {
                String response = rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3);
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JavaFxButtonApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static Connection getConnectionString() {
        Connection con = null;
        String db_URL, db_Username, db_Password;
        try {
            db_URL = "jdbc:oracle:thin:@dilbert.humber.ca:1521:grok";
            db_Username = "N01165469";
            db_Password = "oracle";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(db_URL, db_Username, db_Password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Not able to load driver");
        }
        return con;
    }

}
