package com.ifedoroff.test.app;

import com.ifedoroff.test.app.controller.LoginController;
import com.ifedoroff.test.app.controller.MainController;
import com.ifedoroff.test.app.controller.TitleController;
import com.ifedoroff.test.app.model.EngineHandler;
import com.ifedoroff.test.app.model.VirtualKeyboard;
import com.sun.javafx.scene.control.skin.FXVK;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage;
    @Override
    public void start(final Stage primaryStage) throws Exception{

        LoggFactory.writeLog("Starting application..");
        primaryStage.setMaximized(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        final WebView browser = new WebView();
        browser.setContextMenuEnabled(false);


        final WebEngine webEngine = browser.getEngine();
        StackPane root = new StackPane();


        webEngine.load(Main.class.getClassLoader().getResource("main.html").toString());


        root.getChildren().add(browser);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        EngineHandler.setEngine(webEngine);
        EngineHandler.setView(browser);
        EngineHandler.addController("loginController",new LoginController());
        EngineHandler.addController("titleController",new TitleController());
        EngineHandler.addController("mainController",new MainController());
        stage = primaryStage;
        //EngineHandler.addEventListenersToDOM();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
