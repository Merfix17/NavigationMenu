package com.example.a16day;

public class Friends {
    int image;
    String user;

    Friends(int image, String user){
        this.image = image;
        this.user = user;
    }

    public String getName(){
        return user;
    }
    public int getImage(){
        return image;
    }
}
