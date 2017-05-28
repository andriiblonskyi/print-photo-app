package com.ifedoroff.test.app.model;

import com.ifedoroff.test.app.social.instagram.Instagram;

/**
 * Created by Rostik on 28.05.2017.
 */
public class MediaHandler {
    private static InstagramMedia instagramMedia;

    public static InstagramMedia getInstagramMedia() {
        return instagramMedia;
    }

    public  static void createInstagrammSession(String minId, String maxId, String name, Instagram instagram)
    {
        instagramMedia = new InstagramMedia();
        instagramMedia.setMinId(minId);
        instagramMedia.setMaxId(maxId);
        instagramMedia.setIterator(0);
        instagramMedia.setName(name);
        instagramMedia.setInstagram(instagram);
    }

}
