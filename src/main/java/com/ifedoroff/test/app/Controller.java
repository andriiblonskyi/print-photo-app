package com.ifedoroff.test.app;

import com.ifedoroff.test.app.model.EngineHandler;
import com.sun.javafx.scene.control.skin.FXVK;

/**
 * Created by Rostik on 27.05.2017.
 */
public class Controller {
    public  void testOut(Object value)
    {

        FXVK.init(EngineHandler.getView());
        FXVK.attach(EngineHandler.getView());
    }

}
