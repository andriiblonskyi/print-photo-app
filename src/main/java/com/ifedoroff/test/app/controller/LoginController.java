package com.ifedoroff.test.app.controller;

/**
 * Created by Rostik on 27.05.2017.
 */
public class LoginController implements IController {

    public boolean authorizeInstagram(String login,String password)
    {
        System.out.println("Login: " + login );
        System.out.println("Pswd: " + password );
        return true;
    }

}
