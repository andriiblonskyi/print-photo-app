package com.ifedoroff.test.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ifedoroff.test.app.LoggFactory;
import com.ifedoroff.test.app.model.MediaHandler;
import com.ifedoroff.test.app.social.instagram.Instagram;
import com.ifedoroff.test.app.social.instagram.model.Account;
import com.ifedoroff.test.app.social.instagram.model.Media;

import java.util.List;

/**
 * Created by Rostik on 27.05.2017.
 */
public class LoginController implements IController {

    public boolean authorizeInstagram(String login,String password)
    {
        try {
            LoggFactory.writeLog("Instagram authorization..");
            Instagram instagram = new Instagram();
            instagram.login(login,password);
            System.out.println("Login: " + login );
            System.out.println("Pswd: " + password );
            return true;
        }
        catch (Exception ex)
        {
            return  false;
        }
    }


    public String findUserByName(String name)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Instagram instagram = new Instagram();
            Account account = instagram.getAccountByUsername(name);
            List<Media> mediaList = instagram.getMedias(name,9);
            MediaHandler.createInstagrammSession(mediaList.get(0).id, mediaList.get(mediaList.size()-1).id,name,instagram);
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("type", "success");
            objectNode.put("name", account.fullName);
            objectNode.put("picture", account.profilePicUrl);
            String html = "<div class=\"headerfacebook\"><img src=\"css/Instagram_logo.svg.png\" style=\"height:30%; width:15%; margin-left:43%\"></div>\n" +
                    "<hr>\n" +
                    "<div class=\"accountlogoinstagram\" style=\"background-image: url("+account.profilePicUrl+");\" ></div>\n" +
                    "<p class=\"logoname\">"+account.fullName+"</p>\n" +
                    "<div class=\"container\">\n";
                    for (Media media : mediaList)
                    {
                        html += "    <div class=\"col-3 last\">\n" +
                                "        <button class=\"btnimg\" onclick=\"add()\">\n" +
                                "            <img src="+media.imageUrls.standard+" style=\"height:100%; width:100%\">\n" +
                                "        </button>\n" +
                                "    </div>\n";
                    }

                    html += "</div>\n" +
                    "<div class=\"navigation\">\n" +
                    "<a class=\"left\" onclick=\"insta_left_search()\"></a>\n" +
                            "    <a class=\"right\" onclick=\"insta_right_search()\"></a>"+
                    "\n" +
                    "    <button class=\"basketbtn\" onclick=\"insta_right_search()\">Корзина</button>\n" +
                    "</div>";
            objectNode.put("html",html);
            System.out.println(objectNode.toString());
            return  objectNode.toString();

        }
        catch (Exception ex)
        {
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("type", "error");
            objectNode.put("message", "can't find user with name " + name);
            System.out.println(objectNode);
            return  objectNode.toString();
        }


    }


}
