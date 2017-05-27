package com.ifedoroff.test.app.controller;

import com.ifedoroff.test.app.LoggFactory;
import com.ifedoroff.test.app.social.instagram.Instagram;

/**
 * Created by Rostik on 27.05.2017.
 */
public class LoginController implements IController {

    public boolean authorizeInstagram(String login,String password)
    {
        LoggFactory.writeLog("Instagram authorization..");
        System.out.println("Login: " + login );
        System.out.println("Pswd: " + password );
        return true;
    }

    public boolean findUserByName(String name)
    {
        try {
            Instagram instagram = new Instagram();
            instagram.getAccountByUsername(name);
            return true;
        }
        catch (Exception ex)
        {
            System.out.println();
            return  false;
        }


    }


}
