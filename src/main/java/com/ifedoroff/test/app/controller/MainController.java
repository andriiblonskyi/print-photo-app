package com.ifedoroff.test.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ifedoroff.test.app.model.MediaHandler;
import com.ifedoroff.test.app.social.instagram.Instagram;
import com.ifedoroff.test.app.social.instagram.model.Account;
import com.ifedoroff.test.app.social.instagram.model.Media;

import java.util.List;

/**
 * Created by Rostik on 27.05.2017.
 */
public class MainController implements IController {

    public String getMedia()
    {
        ObjectMapper mapper = new ObjectMapper();
        try {

            List<Media> mediaList = MediaHandler.getInstagramMedia().getInstagram().getMediasInRange(MediaHandler.getInstagramMedia().getName(),9,MediaHandler.getInstagramMedia().getMaxId());
            MediaHandler.getInstagramMedia().setMinId(mediaList.get(0).id);
            MediaHandler.getInstagramMedia().setMaxId(mediaList.get(mediaList.size()-1).id);
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("type", "success");
            String html = "";
            for (Media media : mediaList)
            {
                html += "    <div class=\"col-3 last\">\n" +
                        "        <button class=\"btnimg\" onclick=\"add()\">\n" +
                        "            <img src="+media.imageUrls.standard+" style=\"height:100%; width:100%\">\n" +
                        "        </button>\n" +
                        "    </div>\n";
            }


            objectNode.put("html",html);
            System.out.println(objectNode.toString());
            return  objectNode.toString();
        }
        catch (Exception ex)
        {
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("type", "error");
            objectNode.put("message", "can't find content in range");
            System.out.println(objectNode);
            return  objectNode.toString();
        }


    }
}
