package com.ifedoroff.test.app.model;

import com.ifedoroff.test.app.Main;
import com.sun.javafx.scene.control.skin.FXVK;
import javafx.scene.web.WebView;

/**
 * Created by Rostik on 27.05.2017.
 */
public class VirtualKeyboard {

    public void show() {
        System.out.println("Show");

        FXVK.init(EngineHandler.getView());
        FXVK.attach(EngineHandler.getView());


    }

    public void hide() {
        System.out.println("Hide");
        FXVK.detach();
    }
}