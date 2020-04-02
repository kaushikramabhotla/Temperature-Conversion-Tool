package com.dr3adl0cks.javaapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class myMain extends Application {

	public static void main(String[] args){
		System.out.println("main");
		launch(args);

	}

	@Override
	public void init() throws Exception {

		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}

	private MenuBar createMenu(){

		Menu file = new Menu("file");
		MenuItem newmenuItem = new MenuItem("New");

		newmenuItem.setOnAction(event -> System.out.println("new menu item clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenu = new MenuItem("Quit");
		quitMenu.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});


		file.getItems().addAll(newmenuItem,separatorMenuItem,quitMenu);




		Menu helpmenu = new Menu("help");
		MenuItem about = new MenuItem("about");
		about.setOnAction(event -> aboutApp());
		helpmenu.getItems().addAll(about);



		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(helpmenu,file);
		return menuBar;

	}

	private void aboutApp() {
		Alert alertdialog = new Alert(Alert.AlertType.INFORMATION);
		alertdialog.setTitle("My first java app");
		alertdialog.setHeaderText("learn java");
		alertdialog.setContentText("kaushikkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

		ButtonType yes = new ButtonType("YES");
		ButtonType no = new ButtonType("NO");

		alertdialog.getButtonTypes().setAll(yes,no);
		Optional<ButtonType> clickdbtn = alertdialog.showAndWait();
		if(clickdbtn.isPresent() && clickdbtn.get() == yes){
			System.out.println("yes pressed");
		}
		else {
			System.out.println("no pressed");
		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
