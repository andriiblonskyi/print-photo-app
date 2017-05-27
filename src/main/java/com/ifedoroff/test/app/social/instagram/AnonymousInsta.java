package com.ifedoroff.test.app.social.instagram;

/**
 * Created by Rostik on 27.05.2017.
 */

import com.ifedoroff.test.app.social.instagram.model.Comment;
import com.ifedoroff.test.app.social.instagram.model.Media;

import java.io.IOException;
import java.util.List;

public interface AnonymousInsta extends StatelessInsta {

    List<Media> getLocationMediasById(String locationId, int count) throws IOException;

    List<Media> getMediasByTag(String tag, int count) throws IOException;

    List<Media> getTopMediasByTag(String tag) throws IOException;
    List<Comment> getCommentsByMediaCode(String code, int count) throws IOException;

}