package com.ifedoroff.test.app.controller;

import com.ifedoroff.test.app.Main;
import com.ifedoroff.test.app.model.EngineHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;


/**
 * Created by Rostik on 27.05.2017.
 */
public class TitleController implements IController {

    public String instagramSelected()
    {
        System.out.println("Here");
        String html = "<div id=\"solologininput\" class=\"input\" style=\"margin-top:50%\" contenteditable>@Логин</div>\n" +
                "<h1 style=\"color: white; font-weight: 100;\">или авторизуйтесь</h1>\n" +
                "<div id=\"logininput\" class=\"input\" contenteditable>Логин</div>\n" +
                "<div style=\"margin-top:10px;\" id=\"passwordinput\" class=\"input\" contenteditable>Пароль</div>\n" +
                "\n" +
                "<button class=\"btn\" onclick=\"login()\">Login</button>";
        return html;
        //((WebView)(((StackPane)(Main.stage.getScene().getRoot())).getChildren().get(0))).getEngine().load("http://pikabu.ru/");
        //EngineHandler.getView().getEngine().loadContent("dfsfdgfdsasghjgsdfajhkhsdffk");
        //EngineHandler.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {

        //    public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
        //            Main.stage.show();
        //          }
        //});
    }

    public void addVkListener()
    {
        EngineHandler.addEventListenersToDOM();
    }
}
