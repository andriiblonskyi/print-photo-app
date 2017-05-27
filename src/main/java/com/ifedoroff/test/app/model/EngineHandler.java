package com.ifedoroff.test.app.model;

import com.ifedoroff.test.app.Controller;
import com.ifedoroff.test.app.controller.IController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;

/**
 * Created by Rostik on 27.05.2017.
 */
public class EngineHandler {
    private static WebEngine engine;

    public static void setEngine(WebEngine engine) {
        EngineHandler.engine = engine;
    }

    public static WebEngine getEngine() {
        return engine;
    }

    public static void addController(final String alias, final IController controller)
    {
        if (engine == null)
            return;
        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                                                                  public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
                                                                      if (newState == Worker.State.SUCCEEDED) {
                                                                          JSObject window = (JSObject) engine.executeScript("window");
                                                                          window.setMember(alias, controller);
                                                                      }
                                                                  }
                                                              }
        );
    }
}
