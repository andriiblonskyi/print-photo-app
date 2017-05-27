package com.ifedoroff.test.app.social.instagram;

/**
 * Created by Rostik on 27.05.2017.
 */


import com.ifedoroff.test.app.social.instagram.model.Account;
import com.ifedoroff.test.app.social.instagram.model.Media;
import com.ifedoroff.test.app.social.instagram.model.Tag;

import java.io.IOException;
import java.util.List;

public interface StatelessInsta {

    void basePage() throws IOException;
    Account getAccountByUsername(String username) throws IOException;
    List<Media> getMedias(String username, int count) throws IOException;
    Media getMediaByUrl(String url) throws IOException;
    Media getMediaByCode(String code) throws IOException;
    Tag getTagByName(String tagName) throws IOException;

}