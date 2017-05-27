package com.ifedoroff.test.app;

import com.ifedoroff.test.app.controller.LoginController;
import com.ifedoroff.test.app.model.EngineHandler;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import netscape.javascript.JSObject;

public class Main extends Application {


    @Override
    public void start(final Stage primaryStage) throws Exception{
        primaryStage.setMaximized(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        final WebView browser = new WebView();
        browser.setContextMenuEnabled(false);


        final WebEngine webEngine = browser.getEngine();
        StackPane root = new StackPane();


        webEngine.load(Main.class.getClassLoader().getResource("main.html").toString());
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
                if (newState == Worker.State.SUCCEEDED) {
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    window.setMember("testController", new Controller());
                    }
                }
            }
        );
        root.getChildren().add(browser);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        EngineHandler.setEngine(webEngine);
        EngineHandler.addController("loginController",new LoginController());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
