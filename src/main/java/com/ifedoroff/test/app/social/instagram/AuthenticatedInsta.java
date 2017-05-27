package com.ifedoroff.test.app.social.instagram;

/**
 * Created by Rostik on 27.05.2017.
 */

import com.ifedoroff.test.app.social.instagram.model.Account;
import com.ifedoroff.test.app.social.instagram.model.Comment;

import java.io.IOException;

public interface AuthenticatedInsta extends AnonymousInsta {

    void login(String username, String password) throws IOException;
    Account getAccountById(long id) throws IOException;
    void likeMediaByCode(String code) throws IOException;
    void unlikeMediaByCode(String code) throws IOException;

    Comment addMediaComment(String code, String commentText) throws IOException;

    void deleteMediaComment(String code, String commentId) throws IOException;

}