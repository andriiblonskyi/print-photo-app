package com.ifedoroff.test.app.social.instagram.cookie;

/**
 * Created by Rostik on 27.05.2017.
 */
import okhttp3.Cookie;

import java.util.Collection;

public interface CookieCache extends Iterable<Cookie> {

    void addAll(Collection<Cookie> cookies);
    void clear();

}