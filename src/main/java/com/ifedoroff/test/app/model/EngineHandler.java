package com.ifedoroff.test.app.model;

import com.ifedoroff.test.app.Controller;
import com.ifedoroff.test.app.LoggFactory;
import com.ifedoroff.test.app.controller.IController;
import com.sun.javafx.scene.control.skin.FXVK;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

/**
 * Created by Rostik on 27.05.2017.
 */
public class EngineHandler {
    private static WebEngine engine;
    private static WebView view;

    public static void setView(WebView view) {
        EngineHandler.view = view;
    }

    public static WebView getView() {
        return view;
    }

    public static void setEngine(WebEngine engine) {
        EngineHandler.engine = engine;
    }

    public static WebEngine getEngine() {
        return engine;
    }


    public static void addEventListenersToDOM() {

        if (engine == null || view == null)
            return;
        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {

            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {

                if (newState == Worker.State.SUCCEEDED) {
                    JSObject win = (JSObject) engine.executeScript("window");
                    win.setMember("VirtualKeyboard", new VirtualKeyboard());

                    String script =
                            "var inputsList = document.getElementsByTagName('input');"
                                    +"var element = document.getElementById('test');"
                                    +"element.innerHTML = inputsList.length;"
                                    + "for (var index = 0; index < inputsList.length; ++index) { "
                                    +      "inputsList[index].addEventListener('focus', function() { VirtualKeyboard.show() }, false); "
                                    + "}";
                    engine.executeScript(script);
                }
            }
        });
    }
    public static void addController(final String alias, final IController controller)
    {
        LoggFactory.writeLog("Adding " + alias + " : " + controller.getClass() + " controller..");
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
