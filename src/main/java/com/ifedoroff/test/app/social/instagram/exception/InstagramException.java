package com.ifedoroff.test.app.social.instagram.exception;

import java.io.IOException;

/**
 * Created by Rostik on 27.05.2017.
 */
public class InstagramException extends IOException {

    public InstagramException() {
    }

    public InstagramException(String message) {
        super(message);
    }
}
