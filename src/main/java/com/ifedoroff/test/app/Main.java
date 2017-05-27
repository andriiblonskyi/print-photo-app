package com.ifedoroff.test.app;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(Main.class.getClassLoader().getResource("window.fxml"));
       // Scene scene = new Scene(new Group());
       // System.out.println();
        primaryStage.setMaximized(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        final WebView browser = new WebView();
        browser.setContextMenuEnabled(false);
        browser.setCursor(Cursor.NONE);


        final WebEngine webEngine = browser.getEngine();
        StackPane root = new StackPane();
        root.setCursor(Cursor.NONE);

        //ScrollPane root = new ScrollPane();
        //root.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        //root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        webEngine.load(Main.class.getClassLoader().getResource("main.html").toString());
        //URL url = Main.class.getClassLoader().getResource("main.js");
        //webEngine.loadContent(url.toExternalForm(),"text/javascript");
//        System.out.println(Main.class.getClassLoader().getResource("js/main.js").toString());
        // webEngine.loadContent(,"text/html");
        root.getChildren().add(browser);

        Scene scene = new Scene(root);
        scene.setCursor(Cursor.NONE);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.getScene().setCursor(Cursor.NONE);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
