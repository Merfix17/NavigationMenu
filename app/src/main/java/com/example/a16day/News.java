package com.example.a16day;

public class News {
    int image, icon;
    String user, text;

    public News (int icon, String user, String text, int image) {
        this.icon = icon;
        this.image = image;
        this.user = user;
        this.text = text;
    }

    public int getIcon(){
        return icon;
    }

    public int getImage(){
        return image;
    }

    public String getText(){
        return text;
    }

    public String getUser() {
        return user;
    }
}
