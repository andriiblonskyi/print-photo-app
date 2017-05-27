package com.ifedoroff.test.app.controller;

import com.ifedoroff.test.app.Main;
import com.ifedoroff.test.app.model.EngineHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;


/**
 * Created by Rostik on 27.05.2017.
 */
public class TitleController implements IController {

    public void instagramSelected()
    {
        System.out.println("Here");

        //((WebView)(((StackPane)(Main.stage.getScene().getRoot())).getChildren().get(0))).getEngine().load("http://pikabu.ru/");

        EngineHandler.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {

            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
                System.out.println(EngineHandler.getEngine().getLocation());
                  }
        });

    }
}
