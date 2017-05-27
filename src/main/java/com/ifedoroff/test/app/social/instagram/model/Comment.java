package com.ifedoroff.test.app.social.instagram.model;

/**
 * Created by Rostik on 27.05.2017.
 */
import java.util.Map;

public class Comment {
    public String text;
    public Long createdAt;
    public String id;

    public Account user;

    public static Comment fromApi(Map commentMap) {
        Comment instance = new Comment();
        instance.text = (String) commentMap.get("text");

        try {
            instance.createdAt = (long) (0d + (Double) commentMap.get("created_at"));
        } catch (NullPointerException e) {
            Object time = commentMap.get("created_time");
            if (time instanceof String) {
                instance.createdAt = new Long((String) time);
            } else if (time instanceof Double) {
                instance.createdAt = ((Double) time).longValue();
            }
        }

        instance.id = (String) commentMap.get("id");

        try {
            instance.user = Account.fromAccountPage((Map) commentMap.get("user"));
        } catch (NullPointerException e) {
            instance.user = Account.fromComments((Map) commentMap.get("from"));
        }

        return instance;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", id='" + id + '\'' +
                ", user=" + user +
                '}';
    }
}
