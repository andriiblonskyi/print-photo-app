package com.ifedoroff.test.app.social.instagram.cookie;

import okhttp3.Cookie;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CookieHashSet implements CookieCache {

    private Set<CookieBox> boxes;

    public CookieHashSet() {
        boxes = new HashSet<CookieBox>();
    }

    public void addAll(Collection<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            CookieBox box = new CookieBox(cookie);
            boxes.remove(box);
            boxes.add(box);
        }
    }

    public void clear() {
        boxes.clear();
    }

    public Iterator<Cookie> iterator() {
        return new CookieHashSetIterator();
    }

    private class CookieHashSetIterator implements Iterator<Cookie> {

        private Iterator<CookieBox> iterator;

        CookieHashSetIterator() {
            iterator = boxes.iterator();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public Cookie next() {
            return iterator.next().getCookie();
        }

        public void remove() {
            iterator.remove();
        }
    }
}