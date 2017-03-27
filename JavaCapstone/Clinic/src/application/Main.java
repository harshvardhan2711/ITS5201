package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setPrefWidth(500);
			root.setPrefHeight(300);
			HBox ab = new HBox();
			Button b1 = new Button("Add patient");
			Button b2 = new Button("Remove patient");
			Button b3 = new Button("Clear");
			Label label1 = new Label("Patient ID");
			Label label2 = new Label("First Name");
			Label label3 = new Label("Last Name");
			Label label4 = new Label("Address");
			Label label5 = new Label("State");
			Label label6 = new Label("City");
			Label label7 = new Label("Postal Code");
			Label label8 = new Label("Birth Date");
			Label label9 = new Label("Home Phone");
			Label label10 = new Label("Procedure");
			Label label11 = new Label("Choose Appointment");
			Label label12 = new Label("Choose Appointment Time");
			TextField text1 = new TextField();
			TextField text2 = new TextField();
			TextField text3 = new TextField();
			TextField text4 = new TextField();
			TextField text5 = new TextField();
			TextField text6 = new TextField();
			TextField text7 = new TextField();
			TextField text8 = new TextField();
			TextField text9 = new TextField();
			TextField text10 = new TextField();
			ab.getChildren().addAll(b1, b2, b3);
			GridPane gp = new GridPane();
			gp.add(label1, 0, 0);
			gp.add(label2, 0, 1);
			gp.add(label3, 0, 2);
			gp.add(label4, 0, 3);
			gp.add(label5, 0, 4);
			gp.add(label6, 0, 5);
			gp.add(label7, 0, 6);
			gp.add(label8, 0, 7);
			gp.add(label9, 0, 8);
			gp.add(label10, 0, 9);
			gp.add(label12, 0, 12);
			gp.add(text1, 1, 0);
			gp.add(text2, 1, 1);
			gp.add(text3, 1, 2);
			gp.add(text4, 1, 3);
			gp.add(text5, 1, 4);
			gp.add(text6, 1, 5);
			gp.add(text7, 1, 6);
			gp.add(text8, 1, 7);
			gp.add(text9, 1, 8);
			gp.add(text10, 1, 12);
			procedure pp = new procedure("Teeth Whitening", 5000);
			procedure pp2 = new procedure("Bridges and Implants", 5500);
			procedure pp3 = new procedure("Braces", 3000);
			procedure pp4 = new procedure("Gum Surgery", 6000);
			List<String> aa = new ArrayList<>();
			aa.add(pp.getProcedureDetails());
			aa.add(pp2.getProcedureDetails());
			aa.add(pp3.getProcedureDetails());
			aa.add(pp4.getProcedureDetails());
			ObservableList<String> items = null;

			ListView<String> lv = null;

			items = FXCollections.observableArrayList();
			items.addAll(aa);

			lv = new ListView<>(items);

			lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			root.setCenter(new ScrollPane(lv));
			lv.setPrefWidth(100);
			lv.setPrefHeight(70);

			gp.add(lv, 1, 9);
			gp.add(ab, 1, 10);

			/*
			 * ToolBar toolBar = new ToolBar(new Separator(), new Button("New"),
			 * new Button("Open"), new Button("Save"), new Button("Clean"), new
			 * Separator(), new Button("Compile"), new Button("Run"), new
			 * Button("Debug"), new Button("Profile"), new Separator());
			 */
			MenuBar mb = new MenuBar();
			Menu save = new Menu("File");
			Menu Edit = new Menu("Edit");

			Menu Close = new Menu("Close");
			Menu Clear = new Menu("Clear");
			mb.getMenus().addAll(save, Edit, Close, Clear);
			MenuItem a = new MenuItem("Open");
			MenuItem b = new MenuItem("Save");
			MenuItem c = new MenuItem("Exit");
			save.getItems().addAll(a, b);
			Close.getItems().addAll(c);

			c.setOnAction(e -> System.exit(0));

			root.setTop(mb);
			root.setCenter(gp);
			gp.setAlignment(Pos.CENTER);
			gp.setVgap(10);
			gp.setHgap(10);
			ab.setSpacing(10);
			ab.setPadding(new Insets(10));

			DatePicker dp = new DatePicker();
			dp.setOnAction(e -> {
				LocalDate date = dp.getValue();
			});

			gp.add(label11, 0, 11);
			gp.add(dp, 1, 11);

			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
